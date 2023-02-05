package hackerrank;

public class how_many_word {

    public static int howMany(String sentence) {
    // Write your code here
       String  [] s =  sentence.split("\\s+");
       int i = 0;
       for (String var  : s) {
           if( !var.matches("[A-Za-z.,!\\?\\-]+")) {
               //System.out.println(var);
               i++;
           }
       }
       return s.length - i;
    }

    public static void main(String[] args) {

		// sample case in example
		// output : 7
		System.out.println(howMany("How many eggs are in a half-dozen, 13?"));

		// sample case 0
		// output : 21
		System.out.println(howMany("he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?"));

		// sample case 1
		// output : 21
		System.out.println(howMany("jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj."));
		
		
	}
}


