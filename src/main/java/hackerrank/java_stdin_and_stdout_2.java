package hackerrank;

import java.util.Scanner;

public class java_stdin_and_stdout_2 {
  // input
	//42
	//3.1415
	//Welcome to HackerRank's Java tutorials!
	
  //output
	//String: Welcome to HackerRank's Java tutorials!
	//Double: 3.1415
	//Int: 42
	//
	//
	
	/*
	 * Note: If you use the nextLine() method immediately following the nextInt()
	 * method, recall that nextInt() reads integer tokens; because of this, the last
	 * newline character for that line of integer input is still queued in the input
	 * buffer and the next nextLine() will be reading the remainder of the integer
	 * line (which is empty).
	 */
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        

        // Write your code here.
        int a = scan.nextInt();
        double b = scan.nextDouble();
        scan.nextLine();
        String c = scan.nextLine();
        
        

        System.out.println("String: " + c);
        System.out.println("Double: " + b);
        System.out.println("Int: " + a);
    }
}
