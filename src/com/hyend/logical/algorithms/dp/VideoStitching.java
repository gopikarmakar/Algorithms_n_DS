package com.hyend.logical.algorithms.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/video-stitching/submissions/
 * 
 * @author gopi_karmakar
 */
public class VideoStitching {

	public static void main(String[] args) {
				
		int[][] clips = {{0, 1}, {1, 2}};
		int[][] clips2 = {{0,2}, {4,6}, {8,10}, {1,9}, {1,5}, {5,9}};
		int[][] clips3 = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
		
		System.out.println(videoStitching(clips3, 9));
	}
    
    private static int videoStitching(int[][] clips, int T) {
     
    	int[] dp = new int[T + 1];
        Arrays.fill(dp, T+1);
        dp[0] = 0;
        
        for(int i = 0; i <= T; i++) {
        	
            for(int[] c : clips) {
            	
                if(i >= c[0] && i <= c[1]) { 
                
                	dp[i] = Math.min(dp[i], dp[c[0]] + 1);
                }
            }
            if(dp[i] == T+1) return -1;
        }
        return dp[T];
    }
}
