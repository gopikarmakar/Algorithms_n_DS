package com.hyend.logical.interview.questions.SalesForce;

public class TestSalesForce {

	public static void main(String[] args) {
		
		String[] input = {
                "DEPEND TELNET TCPIP NETCARD\n",
                "DEPEND TCPIP NETCARD\n",
                "DEPEND NETCARD TCPIP\n",
                "DEPEND DNS TCPIP NETCARD\n",
                "DEPEND BROWSER TCPIP HTML\n",
                "INSTALL NETCARD\n",
                "INSTALL TELNET\n",
                "INSTALL foo\n",
                "REMOVE NETCARD\n",
                "INSTALL BROWSER\n",
                "INSTALL DNS\n",
                "LIST\n",
                "REMOVE TELNET\n",
                "REMOVE NETCARD\n",
                "REMOVE DNS\n",
                "REMOVE NETCARD\n",
                "INSTALL NETCARD\n",
                "REMOVE TCPIP\n",
                "REMOVE BROWSER\n",
                "REMOVE TCPIP\n",
                "LIST\n",
                "END\n"
        };
		
		/*for(String line : input)
			System.out.print(line);*/
		
		SalesForceProblem sp = new SalesForceProblem();
		sp.readInput(input);
		sp.printMappings();
		sp.printLogs();		
	}
}
