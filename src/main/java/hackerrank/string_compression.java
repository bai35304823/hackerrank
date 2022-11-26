package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/string-compression/problem
public class string_compression {
	 public static String compress_string(String inp) {
	      String compressed = "";
	      Pattern pattern = Pattern.compile("([\\w])\\1*");
	      Matcher matcher = pattern.matcher(inp);
	      while(matcher.find()) {
	         String group = matcher.group();
	         if (group.length() > 1) compressed += group.length() + "";
	         compressed += group.charAt(0);
	      }
	      return compressed;
	   }
	 
	 
	 private static Scanner inp;

	 public static void main(String args[]) {
	    inp = new Scanner(System.in);
	   String  str=inp.nextLine();
	    List<Character> arrlist = new ArrayList<Character>();
	    for(int i=0; i<str.length();i++){
	        arrlist.add(str.charAt(i));
	    }
	    for(int i=0; i<str.length();i++){
	        int freq = Collections.frequency(arrlist, str.charAt(i));
	        System.out.println("Frequency of "+ str.charAt(i)+ "  is:   "+freq); 
	    }
	      }    
	 }

