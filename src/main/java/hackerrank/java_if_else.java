package hackerrank;

import java.util.Scanner;

public class java_if_else {


	



		    private static final Scanner scanner = new Scanner(System.in);

		    public static void main(String[] args) {
		        int N = scanner.nextInt();
		        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		        System.out.println( ((N%2 == 0) 
		        		&& ((N>=2 && N<=5)||N>20)) 
		        		? "Not Weird" : "Weird");
		        scanner.close();
		    }
		}
	


