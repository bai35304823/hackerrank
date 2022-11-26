package hackerrank;

import java.util.Scanner;

public class java_string_tokens {

	public static void main(String[] args) { Scanner scan = new Scanner(System.in); String s = scan.nextLine(); // Write your code here. scan.close();

    s = s.trim();

    if(s.length()<=0){
        System.out.println(0);
        return;

    }else{
         String[] tokens = s.split("[ ?._'@!,]+");
           System.out.println(tokens.length);
                for(String x : tokens){
                    System.out.println(x);
                   }
       }

}
}


