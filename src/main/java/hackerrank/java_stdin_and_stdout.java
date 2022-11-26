package hackerrank;

import java.util.Scanner;

public class java_stdin_and_stdout {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	String myString = scanner.next();
	int myInt = scanner.nextInt();
	scanner.close();
	// Hi 5
	System.out.println("myString is: " + myString);
	System.out.println("myInt is: " + myInt);
	
	// myString is: Hi
	 //myInt is: 5
	    }
}
