package hackerrank;

import java.util.Scanner;

public class java_datatypes {
	//A byte is an 8-bit signed integer.
	//A short is a 16-bit signed integer.
	//An int is a 32-bit signed integer.
	//A long is a 64-bit signed integer.
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int t=sc.nextInt();

	        for(int i=0;i<t;i++)
	        {

	            try
	            {
	                long x=sc.nextLong();
	                System.out.println(x+" can be fitted in:");
	                if(x>=-128 && x<=127){
	                    System.out.println("* byte");}
	                if(x>= -32768  && x<=32767){
	                    System.out.println("* short");}
	                if(x>=Math.pow(-2,31) && x<=(Math.pow(2,31)-1)){
	                     System.out.println("* int");}
	                if(x>=Math.pow(-2,63) && x<=(Math.pow(2,63)-1)){
	                    System.out.println("* long");}
	            }
	            catch(Exception e)
	            {
	                System.out.println(sc.next()+" can't be fitted anywhere.");
	            }

	        }
	}
}
