package com.hyend.logical.algorithms.dp.recursive;

/**
 * Compute all permutations that can be formed using a, b and c under given constraints:
 * Given a length n, count the number of strings of length n that can be made using
 * ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
 * 
 * @author gopi_karmakar
 */
public class PermutationsWithContraint {
	
	public static void main(String[] args) {
		
		System.out.println("\nThere're Total " + permutations(3, 1, 2, "") + " Of Such Permutations");
	}
		
	/**
	 * The time complexity is determined by the number of recursive calls.
	 * since within each function the time spent is 0(1),
	 * 
	 * So, the time complexity is O(n X n!), since we do O(n) 
	 * computation per call outside of the recursive calls and
	 * permutations of any n takes n! time.
	 */
	public static int permutations(int n, int bCount, int cCount, String prefix) {
		if(n == 0) {
			System.out.println(prefix);
			return 1;
		}
		
		int total = 0;
		
		total += permutations(n-1, bCount, cCount, prefix + 'a');
		
		if(bCount > 0) {
			total += permutations(n-1, bCount-1, cCount, prefix + 'b');
		}
		if(cCount > 0) {
			total += permutations(n-1, bCount, cCount-1, prefix + 'c');
		}		
		return total;
	}
}