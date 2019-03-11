package com.hyend.logical.designs;

import java.util.Map;
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
	
	private int sizeLimit = 0;
	private final long expiryTime = 7000;	//7 seconds

	public LimitedObjectPool(int limit) {
		this.sizeLimit = limit;
	}
	
	ConcurrentHashMap<DataObject, Long> inUse = new ConcurrentHashMap<>();
	ConcurrentHashMap<DataObject, Long> available = new ConcurrentHashMap<>(this.sizeLimit);

	public DataObject getObject() {
		
		if(!available.isEmpty()) {
			if(available.size() >= sizeLimit) {
				makeAvailability(available);
			}
			else {
				for(Map.Entry<DataObject, Long> entry: available.entrySet()) {
					if((System.currentTimeMillis() - entry.getValue()) > expiryTime) {
						//Time has expired
						makeAvailability(available, entry.getKey());
					}
					else {
						DataObject object = makeAvailability(available, entry.getKey());
						push(inUse, object, System.currentTimeMillis());
						return object;
					}
				}				
			}			
		}
		return createObject();
	}

	public void makeItAvailable(DataObject key) {
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
	
	private void makeAvailability(ConcurrentHashMap<DataObject, Long> map) {
		Map.Entry<DataObject, Long> entry = map.entrySet().iterator().next();
		DataObject key = entry.getKey();
		map.remove(key);		
	}

	private DataObject makeAvailability(ConcurrentHashMap<DataObject, Long> map, DataObject key) {
		cleanUp(key);
		map.remove(key);
		return key;
	}

	private void cleanUp(DataObject object) {
		object.setName(null);
		object.setAddress(null);
		object.setPhoneNum(null);
	}
}
