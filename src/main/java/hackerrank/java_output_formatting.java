package hackerrank;

import java.util.Scanner;

public class java_output_formatting {
	//Sample Input

	//java 100
	//cpp 65
	//python 50
	
	
	//Sample Output

	//================================
	//java           100 
	//cpp            065 
	//python         050 
	//================================
	
	
	
	// -14 s= left justified string with 14 chars. 
	//		he then adds a space in formater to make the 15th char. 
		//	%0 makes it padded, the 3 limits int to 999. %n is next line.
	// Finally the s means, that you are formatting a string.
		//  Finally d means, that a integer is formatted.
	
	
	// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
	 public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         System.out.println("================================");
         for(int i=0;i<3;i++){
             String s1=sc.next();
             int x=sc.nextInt();
             //Complete this line
             System.out.printf("%-14s %03d %n" , s1, x);
         }
         System.out.println("================================");

 }
}
