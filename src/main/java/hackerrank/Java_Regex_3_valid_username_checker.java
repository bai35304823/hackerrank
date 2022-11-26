package hackerrank;

public class Java_Regex_3_valid_username_checker {
	
	/*
	 * The \w metacharacter matches word characters.
	 * 
	 * A word character is a character a-z, A-Z, 0-9, including _ (underscore).
	 */
    public static void main(String[] args) {
    	String regex = "^[aA-zZ]\\w{7,29}$";
	}
    String regex = "^[aA-zZ]\\w{7,29}$";
    //If someone manages to reach my comment, let me explain, 
    //in detail, why this works. ^ represents that starting 
    //character of the string. [aA-zZ] makes sure that the 
    //starting character is in the lowercase or uppercase 
    //alphabet. \\w{7,29} represents a check to make sure 
    //that the remaining items are word items, which includes 
   /// the underscore, until it reaches the end and that is 
   // represented with $. The {7,29} represents the 8-30 
  //  character constraint given to us minus the predefined first character.
}
