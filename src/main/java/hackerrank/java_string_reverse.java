package hackerrank;

import java.util.Scanner;

public class java_string_reverse {
	public static void main(String[] args) {

	    Scanner sc=new Scanner(System.in);
	    String A=sc.next();
	    String rev = new StringBuilder(A).reverse().toString();

	    System.out.println(A.equals(rev) ? "Yes" : "No");
	}
}
