package hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java_Regex_2_duplicate_word {
	 public static void main(String[] args) {

	        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
	        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

	        Scanner in = new Scanner(System.in);
	        int numSentences = Integer.parseInt(in.nextLine());
	        
	        while (numSentences-- > 0) {
	            String input = in.nextLine();
	            
	            Matcher m = p.matcher(input);
	            
	            // Check for subsequences of input that match the compiled pattern
	            while (m.find()) {
	                input = input.replaceAll(m.group(), m.group(1));
	            }
	            
	            // Prints the modified sentence.
	            System.out.println(input);
	        }
	        
	        in.close();
	    }
	 
	 
		/*
		 * Regex I used this regular expression: "\b(\w+)(?:\W+\1\b)+"
		 * 
		 * When using this regular expression in Java, we have to "escape" the backslash
		 * characters with additional backslashes (as done in the code above).
		 * 
		 * \w ----> A word character: [a-zA-Z_0-9] \W ----> A non-word character: [^\w]
		 * \b ----> A word boundary \1 ----> Matches whatever was matched in the 1st
		 * group of parentheses, which in this case is the (\w+) + ----> Match whatever
		 * it's placed after 1 or more times
		 * 
		 * The \b boundaries are needed for special cases such as "Bob and Andy" (we
		 * don't want to match "and" twice). Another special case is
		 * "My thesis is great" (we don't want to match "is" twice).
		 */
		/*
		 * m.group() is the entire match m.group(i) is the ith match. So m.group(1) is
		 * the 1st match (which is enclosed in the 1st set of parentheses)
		 * 
		 * The ?: is added to make it a "non-capturing group" (meaning you can't do
		 * group() to get the group), for slightly faster performance.
		 * 
		 * Hope this helps.
		 */

		/*
		 * abconline 7 years ago I find it is very helpful to go through the Java
		 * tutorial to understand the grouping concept:
		 * https://docs.oracle.com/javase/tutorial/essential/regex/groups.html
		 * 
		 * The pattern above basically means to capture any pattern where a word ((\w+))
		 * is followed by non-word character (e.g., space) then by itself again (\1 is
		 * the backreference to (\w+) earlier).
		 * 
		 * So for the example input"Goodbye bye bye world world world", the matcher will
		 * find 3 patterns:
		 * 
		 * 1) Goodbye
		 * 
		 * 2) bye bye
		 * 
		 * 3) world world world
		 * 
		 * Then for each of them, we can call replaceAll to replace the whole group with
		 * the first group (i.e., the first word - m.group(1)).
		 * 
		 * Hope this helps.
		 */
	 
	 
}
