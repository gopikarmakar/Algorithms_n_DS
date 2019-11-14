package com.hyend.logical.algorithms.dp.recursive;

/**
 * ### Google Interview Question ### 
 * 
 * There is student attendance information that has 3 state.
 *
 *	O: attendance
 *	L: late
 *	A: absent
 *	
 *	If student is "absent two days in total" OR "late three days in a row", student get penalty.
 *	
 *	There are 8 ways that student get penalty in 3 days.
 *	
 *	LLL   AAO   AOA   OAA   
 *	ALA   LAA   AAL   AAA
 *	
 *	There are 38 ways that student get penalty in 4 days
 *	
 *	AAOO   AAOL   AALO   AALL   AOAO
 *	AOAL   ALAO   ALAL   AOOA   AOLA
 *	ALOA   ALLA   OAAO   OAAL   LAAO
 *	LAAL   OAOA   OALA   LAOA   LALA
 *	OOAA   OLAA   LOAA   LLAA   AAAO
 *	AAAL   AAOA   AALA   AOAA   ALAA
 *	OAAA   LAAA   AAAA   LLLO   LLLA
 *	OLLL   ALLL   LLLL
 *
 * 	Problem:
 * 	One semester is N days. Given an integer N, generate the number of ways that student get penalty.
 *
 * 	Example-1
 * 	Input : 3
 * 	Output : 8
 *
 * 	Example-2
 * 	Input : 4
 * 	Output : 38
 * 
 *  Solution:
 *  Actually the solution is quite simple, if we understand the Mathematics topics like, Probability & Calculus.
 *  
 *  Let's understand the solution point by point here.
 *  1) Minimum there're definitely two sure ways to get the penalty always, 1: All Days Absent 2: All Days Late.
 *     So let's initialize the totalWays = 2;
 *  2) Now, Let's try to solve the problem for 3days first, There can be only 1 way to get the late penalty 
 *     with in 3days(LLL), which we already considered above in 1st point.
 *  3) The probability to be either O A L for each day is 3 and there are total 3days. So, 3 X 3 X 3 = 27, which means
 *     There're 27 ways in total to get the penalty within 3days.
 *  4) Now, let's take the absent & present(AO) case first, If a student absents in 1st day then the probability to be absent for 
 *     next time will be with in 2 days only. Which means, the probability of absent for each day with in 3 days is 3 X 2 X 1 = 6
 *  5) Now, here's a catch, if you observe here, OAA or AOA or AAO are the same thing, So we need to remove the duplicates. 
 *     Then, finally the total probability for absent & present(AO) case within 3days will be 6/2 = 3
 *  6) Same way the total probability for absent & late(AL) case within 3days will be 3 too.
 *  7) We don't care for late and present case because, there are max 3days and if a student is present in any of the day,
 *     then that student can't get penalty for being late anymore, but for >3days, we'll calculate the Late & present(LO) case as well.
 *  8) So, in that case the total ways are, 2 + 3 + 3 = 8 ways to get penalty with in three days.    
 *  
 *  @author gopi_karmakar         
 */
public class StudentAttendance {
	
	int totalWays = 2;
	
	public static void main(String[] args) {
		
		System.out.println(new StudentAttendance().waysToGetPenalty(3));
	}
	
	private int factorial(int days) {
		
		if(days == 0) return 1;
		return days * factorial(days-1);
	}
	
	public int getTotalWaysOfPenalty(int days) {
		
		if(days < 2) return 0;
		
		int totalWays = 2;
		
		switch (days) { 
			case 2:
				totalWays = 1;
				break;
			case 3:
				// totalWays += (AO)/2 + (AL)/2
				//totalWays += factorial(days)/2 + factorial(days)/2;
				totalWays += 2*(factorial(days)/2);
				break;
			default:
				// totalways += (A)/2 + (L)/2 + (AL)/2 
				//                6 +     12 +   6+12   
				//				  10  +   60  +    30   +   40 
				//			       15     360 +    60   +   
				//totalWays += factorial(days)/2 + factorial(days)/2 + factorial(days)/2;
				totalWays += 3*(factorial(days)/2);
				break;
		}
		return totalWays;
	}
	
	public int waysToGetPenalty(int days){
        return getPenaltyWays(days, 1, '#', '#', 0, false);
    }

    private int getPenaltyWays(int days, int currDay, char prev, char prev2, 
            int aCount, boolean penalty) {
        if(currDay > days){
            if(penalty){
                return 1;
            }
            return 0;
        }

        int count = 0;
        // add L
        count += getPenaltyWays(days, currDay + 1, 'L', prev, aCount, 
        penalty || (prev == 'L' && prev2 == 'L'));

        // add O
        count += getPenaltyWays(days, currDay + 1, 'O', prev, aCount, 
        penalty);

        // add A
        count += getPenaltyWays(days, currDay + 1, 'A', prev, aCount + 1, 
        penalty || (aCount + 1 >= 2));

        return count;        
    }
}
