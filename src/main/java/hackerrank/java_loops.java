package hackerrank;

import java.util.Scanner;

public class java_loops {
public static void main(String[] args) {
	
	
	double aa = 30;
    double bb = 2;
    System.out.println(Math.pow(aa, bb));

    aa = 3;
    bb = 4;
    System.out.println(Math.pow(aa, bb));

    aa = 2;
    bb = 6;
    System.out.println(Math.pow(aa, bb));
	
    // output : 
    //900.0
   // 81.0
   // 64.0
	//
	
	
	
	
	
	
	
	Scanner in = new Scanner(System.in);
    int prev=0;
    int rslt=0;
    int t=in.nextInt();
    for(int i=0;i<t;i++){
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        for (int k=0;k<n;k++){
            prev+=Math.pow(2,k)*b;
            rslt=a+prev;
            System.out.print(rslt+" ");
        }
        System.out.println();  
        prev=0;
    }
    in.close();
}
}
