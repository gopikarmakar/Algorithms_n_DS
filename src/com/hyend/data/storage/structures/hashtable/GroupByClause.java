package com.hyend.data.storage.structures.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Partitioning and sorting an array with many repeated entries. 
 * for e.g: arr = [b,a,c,b,d,a,b,d] then,
 * (a,a,b,b,b,c,d,d) or (a,a,b,b,b,d,d,c) or (c,d,d,b,b,b,a,a).
 * is an acceptable reordering. Sortedness of the reordered entries dosn't matter. 
 * 
 * Variant: Implement a groupBy clause.
 * For e.g: 
 * Group all the same age student's record adjacent to each other.
 * 
 * @author gopi_karmakar
 */
public class GroupByClause {

	public static void main(String[] args) {
		
		groupBy(createSampleData()).forEach(e -> {
			
			System.out.println(e);
		});;
	}
	
	private static class Student {
		String name;
		int age;
		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString() {
			return "Name = \t" + name + "\tAge = \t" + age ;
		}
	}
	
	/**
	 * The time complexity is O(n) where n is the total number of records.
	 * Space complexity is O(m) where m is the distinct ages in the records. 
	 */
	private static List<Student> groupBy(List<Student> records) {
		
		records.forEach(e -> {
			System.out.println(e);
		});
		
		Map<Integer, Integer> sameAgeStudents = new HashMap<>();
		
		records.forEach(e -> {
			
			int age = sameAgeStudents.getOrDefault(e.age, 0);
			sameAgeStudents.put(e.age, age+1);
		});
		
		System.out.println("\n" + sameAgeStudents + "\n");
		
		Map<Integer, Integer> ageToOffsets = new HashMap<>();
		
		int offset = 0;		
		for(Map.Entry<Integer, Integer> e : sameAgeStudents.entrySet()) {
			
			ageToOffsets.put(e.getKey(), offset);
			offset += e.getValue();
		}
		
		System.out.println(ageToOffsets + "\n");
		
		while(!ageToOffsets.isEmpty()) {
			
			// Every time just fetching the first object from ageToOffsets set.
			Map.Entry<Integer, Integer> from = ageToOffsets.entrySet().iterator().next();
			
			int studentAge = records.get(from.getValue()).age;
			int offsetOfThatAge = ageToOffsets.get(studentAge);
			
			Collections.swap(records, from.getValue(), offsetOfThatAge);
			
			// Use sameAgeStudents to see when we are finished with a particular age.
			int count = sameAgeStudents.get(studentAge) - 1;
			sameAgeStudents.put(studentAge, count);
			
			if(count > 0) {
				ageToOffsets.put(studentAge, offsetOfThatAge + 1);
			}
			else {
				ageToOffsets.remove(studentAge);
			}
		}			
		return records;
	}
	
	private static List<Student> createSampleData() {
		
		List<Student> studentRecord = new ArrayList<>();
		
		String[][] records = {{"Greg", "14"}, {"John", "12"}, {"Andy", "11"}, {"Chip", "13"},
							  {"Jim", "13"}, {"Phil", "12"}, {"Bob", "13"}, {"Tim", "14"}};
		
		for(int i = 0; i < records.length; ++i) {
			
			Student student = new Student(records[i][0], Integer.parseInt(records[i][1]));
			studentRecord.add(student);
		}		
		return studentRecord;
	}
}
