package com.hyend.logical.algorithms;

public class AmountInWords {

	private String ones_n_teens[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
							 "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	
	private String tens[] = {"zero", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public String translateMoney(int value) {
		
		int index = 0, digits = 0, quo = 0;
		int[] rem = new int[10];
		String amountInWords = "";
		do {			
			rem[index] = value % 10;	
			value = value / 10;
			digits += 1;
			switch (digits) {
			case 1:
				amountInWords = " " + ones_n_teens[rem[index]];
				break;
			case 2:
				amountInWords = getOnesTeensTys(rem, index);
				break;
			case 3:				
				amountInWords = getHundreds(rem, index)+getOnesTeensTys(rem, index-1);
				break;
			case 4:				
				amountInWords = getThousands(rem, index)+getHundreds(rem, index-1)+getOnesTeensTys(rem, index-2);
				break;
			case 5:
				amountInWords = getTenThousands(rem, index)+getHundreds(rem, index-2)+getOnesTeensTys(rem, index-3); 
				break;
			case 6:
				if(isAnyTensThousands(rem, index-1))
					amountInWords = getHundreds(rem, index)+getTenThousands(rem, index-1)+getHundreds(rem, index-3)+getOnesTeensTys(rem, index-4);
				else					
					amountInWords = getHundreds(rem, index)+getThousands(rem, index-2)+getHundreds(rem, index-3)+getOnesTeensTys(rem, index-4);
				break;
			case 7:
				if(isAnyHundredThousands(rem, index-1))
					amountInWords = getMillions(rem, index)+getHundreds(rem, index-1)+getTenThousands(rem, index-2)+getHundreds(rem, index-4)+getOnesTeensTys(rem, index-5);
				else if(isAnyTensThousands(rem, index-2))
					amountInWords = getMillions(rem, index)+getTenThousands(rem, index-2)+getHundreds(rem, index-4)+getOnesTeensTys(rem, index-5);
				else
					amountInWords = getMillions(rem, index)+getThousands(rem, index-3)+getHundreds(rem, index-4)+getOnesTeensTys(rem, index-5);					
				break;
			case 8:					
				break;
			default:
				break;
			}
			index+=1;
		} while(value != 0);	
		return amountInWords;
	}
	
	public String getOnesTeensTys(int rem[], int index) {
		
		int total = (rem[index] * 10) + rem[index-1];
		String amountInWords = "";
		if(total != 0) {
			if(total < ones_n_teens.length-1) {
				amountInWords = " " + ones_n_teens[total];
			}
			else {
				if((total%10) == 0)
					amountInWords = " " + tens[rem[index]];					
				else
					amountInWords = " " + tens[rem[index]] + ones_n_teens[rem[index-1]];
			}
		}
		return amountInWords;
	}
	
	public String getHundreds(int rem[], int index) {
		String amountInWords = " hundred";
		if(rem[index] != 0)
			amountInWords = " " + ones_n_teens[rem[index]] + " hundred";
		return amountInWords;
	}
	
	public String getThousands(int rem[], int index) {
		String amountInWords = " thousand";
		if(rem[index] != 0)
			amountInWords = " " + ones_n_teens[rem[index]] + " thousand";
		return amountInWords;
	}
	
	public boolean isAnyTensThousands(int rem[], int index) {
		return (rem[index] != 0);
	}
	
	public boolean isAnyHundredThousands(int rem[], int index) {
		return (rem[index] != 0);
	}
	
	public String getTenThousands(int rem[], int index) {
		String amountInWords = " thousands";
		if(rem[index] != 0)
			amountInWords = " " + getOnesTeensTys(rem, index) + " thousands";
		return amountInWords;
	}
	
	public String getHundredThousands(int rem[], int index) {
		String amountInWords = " thousands";
		if(rem[index] != 0)
			amountInWords = " " + getOnesTeensTys(rem, index) + " thousands";
		return amountInWords;
	}
	
	public String getMillions(int rem[], int index) {
		String amountInWords = " million";
		if(rem[index] != 0)
			amountInWords = " " + ones_n_teens[rem[index]] + " million";
		return amountInWords;
	}
	
	public String getTensMillions(int rem[], int index) {		
		return " " + getOnesTeensTys(rem, index) + " millions";		
	}
}
