package hackerrank;

public class java_regex {
public static void main(String[] args) {
	
/*	IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255. 
	Leading zeros are allowed. The length of A, B, C, or D 
	can't be greater than 3.
*//*	A simple approach is:

		String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
		public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
		1) \\d{1,2} catches any one or two digit number

		2) (0|1)\\d{2} catches any three digit number starting with 0 or 1.

		3) 2[0-4]\\d catches numbers between 200 and 249.

		4) 25[0-5] catches numbers between 250 and 255.
*/
	//	Note that \d represents digits in regular expressions, same as [0-9]
	String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
	String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
	
} 
}
