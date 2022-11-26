package hackerrank;

public class how_many_word {

    public static int howMany(String sentence) {
    // Write your code here
       String  [] s =  sentence.split("\\s+");
       int i = 0;
       for (String var  : s) {
           if( !var.matches("[A-Za-z.,!\\?\\-]+")) {
               System.out.println(var);
               i++;
           }
       }
       return s.length - i;
    }

}


