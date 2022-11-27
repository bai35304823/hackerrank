package hackerrank;
//https://www.gohired.in/2015/05/10/convert-number-roman-number/
public class convert_number_roman_number {

	/*
	 * Convert Decimal to Roman numbers / Romanizer HackerEarth Code May 10, 2015 by
	 * Dhaval Dave
	 * 
	 * Set of Numbers are given to you. convert them to Roman numbers. Solution is
	 * in Hacker Earth style
	 */

	static String[] romanizer(int[] num) {
	    String ans[] = new String[num.length];
	    for(int i=0; i<num.length;i++){          
	           ans[i]=convertToRoman(num[i]);       
	        }
	        return ans;     
	}
	static String convertToRoman(int val){                
	          String res=""; 
	          String huns[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};         
	          String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};         
	          String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};                 
	          int   size[] = { 0,   1,    2,     3,    2,   1,  2,      3,       4,     2};     
	 
	          while (val >= 1000) {
	             res=res+'M';
	             val -= 1000;
	      }
	       
	      res=res+huns[val/100];
	      val = val % 100;
	       
	          res=res+ tens[val/10];  
	      val = val % 10;
	       
	          res=res+ ones[val];
	      return res;
	    }

}
