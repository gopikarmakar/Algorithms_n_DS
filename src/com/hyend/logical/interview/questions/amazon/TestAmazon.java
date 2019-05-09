package com.hyend.logical.interview.questions.amazon;

public class TestAmazon {
	
	public static void main(String[] args) {
		
		FindCommonManager mgr = new FindCommonManager();
		mgr.empToMgrMapping(mgr.createSampleData());
		String mngr = mgr.findCommonManager("5001", "4501");
		if(mngr != null)
			System.out.println("Common Manager = " + mngr);
		else 
			System.out.println("No Common Manager");		
	}
}
