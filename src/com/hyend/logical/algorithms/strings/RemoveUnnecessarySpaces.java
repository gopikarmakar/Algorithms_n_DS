package com.hyend.logical.algorithms.strings;

/**
 * A Google Interview Question
 * 
 * Remove unnecessary spaces from a String
 * 
 * @author gopi_karmakar
 */
public class RemoveUnnecessarySpaces {

	public static void main(String[] args) {
		
		String s = "I   live   on     earth";
		System.out.println(remove(s)); 
	}
	
	/**
	 * O(n) time and O(1) extra space complexity solution.
	 */
	private  static String remove(String s) {
		
		boolean flag = false;
		StringBuilder result = new StringBuilder();
		
		/*for(char c : s.toCharArray()) {
			
			if(c != ' ') {
				flag = false;
				sb.append(c);				
			}
			else {
				if(flag == false) {
					sb.append(' ');
					flag = true;
				}
			}
		}*/
		for(char c : s.toCharArray()) {

			if(c == ' ') flag = true;
			else {

				if(flag) {
					result.append(' ');
					flag = false;
				}
				result.append(c);
			}
		}
		
		return result.toString();
	}
}
