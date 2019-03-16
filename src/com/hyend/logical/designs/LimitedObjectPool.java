package com.hyend.logical.designs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A size limited Object Pool. It can be considered as a time limited Hashmap too.
 * Which was a google telephonic interview question.
 * 
 * @author gopi_karmakar
 *
 */
public class LimitedObjectPool {
	
	public static class DataObject {
		
		public String name;
		public String address;
		public String phoneNum;
		
		public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return this.address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhoneNum() {
			return this.phoneNum;
		}
		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}
	}
	
	private int threshold = 0;
	private final long expiryTime = 7000;	//7 seconds

	public LimitedObjectPool(int threshold) {
		this.threshold = threshold;
	}
	
	ConcurrentHashMap<DataObject, Long> inUse = new ConcurrentHashMap<>();
	ConcurrentHashMap<DataObject, Long> available = new ConcurrentHashMap<>();

	public DataObject getObject() {
		
		if(!available.isEmpty()) {
			if(available.size() <= threshold) {
				DataObject object  = validateCache();
				if(object != null)
					return object;						
			}
			else {
				/**
				 * Free space in case of cache reaches size threshold.
				 */
				invalidateExpiredOnes();			
			}
		}
		return createObject();
	}

	public void makeItAvailable(DataObject key) {
		cleanUp(key);
		Long now = System.currentTimeMillis();	
		available.put(key, now);
		inUse.remove(key);
	}
	
	private DataObject createObject() {		
		DataObject object = new DataObject();
		return push(inUse, object, System.currentTimeMillis());
	}

	private DataObject push(ConcurrentHashMap<DataObject, Long> map, DataObject key, Long time) {
		map.put(key, time);
		return key;
	}

	private DataObject makeAvailability(DataObject key) {
		available.remove(key);
		return key;
	}
	
	private DataObject validateCache() {
		
		DataObject object = invalidateExpiredOnes();
		if(object != null) {
			makeAvailability(object);
			push(inUse, object, System.currentTimeMillis());
			return object;
		}				
		return null;
	}
	
	private DataObject invalidateExpiredOnes() {
		
		Iterator<Map.Entry<DataObject, Long>> itr = available.entrySet().iterator();	
		
		while(itr.hasNext()) {
			Map.Entry<DataObject, Long> entry = itr.next();
			if((System.currentTimeMillis() - entry.getValue()) > expiryTime) {
				//Time has expired
				makeAvailability(entry.getKey());
			}
			else {
				return entry.getKey();
			}
		}
		return null;
	}

	private void cleanUp(DataObject object) {
		object.setName(null);
		object.setAddress(null);
		object.setPhoneNum(null);
	}
}
