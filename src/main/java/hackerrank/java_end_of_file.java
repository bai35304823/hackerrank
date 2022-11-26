package hackerrank;

import java.util.Scanner;

public class java_end_of_file {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        int n=1;
	        while(sc.hasNext()) {
	            System.out.println(n++ + " " + sc.nextLine());
	        }
	        
	        sc.close();
	    }
}
