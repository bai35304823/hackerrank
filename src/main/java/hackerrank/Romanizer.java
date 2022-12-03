
package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author m
 * @score 50/50
 */
public class Romanizer {

	public static List<String> romanizer(List<Integer> numbers) {

		// String strArr[] =
		// {"M","CM","D","CD","C","XC","L","XL","X","IX","VIII","VII","VI","V","IV","III","II","I"};
		// int digitArr[] = {1000, 990, 500, 400, 100, 90, 50, 40, 10, 9, 8, 7, 6, 5, 4,
		// 3, 2,1};

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
		intLst.add(900);
		intLst.add(500);
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
			int l = 0;
			while (intLstSize == l || number > 0) {
				while (number - intLst.get(j) >= 0) {
					number = number - intLst.get(j);
					strBf.append(strLst.get(j));
				}
				j++;
				l = j - 1;
			}
			result.add(strBf.toString());
		}

		return result;
	}

	public static void main(String[] args) {
		// Sample Case 0
		// output: [I, II, III, IV, V]
		System.out.println(romanizer(List.of(1, 2, 3, 4, 5)));
		
		// Sample Case 1
		// output: [LXXV, LXXX, XCIX, C, L]
		System.out.println(romanizer(List.of(75, 80, 99, 100, 50)));
	}

}
