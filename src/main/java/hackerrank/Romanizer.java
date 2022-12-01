

package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author m
 *
 */
public class Romanizer {

	public static  List<String> getRoman(List<Integer> numbers) {


		//String strArr[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","VIII","VII","VI","V","IV","III","II","I"};	
	    //int digitArr[] = {1000, 990, 500, 400, 100, 90, 50, 40, 10, 9, 8, 7, 6, 5, 4, 3, 2,1};
	    
	    ArrayList<String> strLst = new ArrayList<String>();
	    strLst.add("M");
	    strLst.add("CM");
	    strLst.add("D");
	    strLst.add("CD");
	    strLst.add("C");
	    strLst.add("XC");
	    strLst.add("L");
	    strLst.add("XL");
	    strLst.add("X");
	    strLst.add("IX");
	    strLst.add("VIII");
	    strLst.add("VII");
	    strLst.add("VI");
	    strLst.add("V");
	    strLst.add("IV");
	    strLst.add("III");
	    strLst.add("II");
	    strLst.add("I");
	    
	    ArrayList<Integer> intLst = new ArrayList<Integer>();
	    intLst.add(1000);
	    intLst.add(990);
	    intLst.add(50);
	    intLst.add(400);
	    intLst.add(100);
	    intLst.add(90);
	    intLst.add(50);
	    intLst.add(40);
	    intLst.add(10);
	    intLst.add(9);
	    intLst.add(8);
	    intLst.add(7);
	    intLst.add(6);
	    intLst.add(5);
	    intLst.add(4);
	    intLst.add(3);
	    intLst.add(2);
	    intLst.add(1);
	    
	    List<String> result = new ArrayList<String>();
	    
	    for (Integer number : numbers) {
	    	StringBuffer strBf = new StringBuffer();
		    int j = 0;
		    int intLstSize = intLst.size();
		    int sub = 0;
		    int l = 0;
		    while (intLstSize == l || number > 0) {
		        while (number - intLst.get(j) >= 0) {
		        	number = number - intLst.get(j);
		            strBf.append(strLst.get(j));     
		        }
		        j++;
		        l = j-1;
		    }
		    result.add(strBf.toString());
	    }
	    
	    return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		Integer[] number = new Integer[] {1,2,3,4,5};
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		List<String> returnLst = new ArrayList<String>();
		
		
		for(int i=0;i<number.length;i++) {
			try {
				try {
					returnLst = getRoman(list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0;i< returnLst.size();i++) {
			System.out.println(returnLst.get(i));
		}
	}

}
