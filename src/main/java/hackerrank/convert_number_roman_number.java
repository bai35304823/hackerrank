package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//https://www.gohired.in/2015/05/10/convert-number-roman-number/
public class convert_number_roman_number {

	/*
	 * Convert Decimal to Roman numbers / Romanizer HackerEarth Code 
	 * 
	 * Set of Numbers are given to you. convert them to Roman numbers. Solution is
	 * in Hacker Earth style
	 */

	static List<String> romanizer(List<Integer> numbers) {
		int[] num = Optional.ofNullable(numbers).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

		String ans[] = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			ans[i] = convertToRoman(num[i]);
		}
		return Arrays.stream(ans).collect(Collectors.toList());
	}

	static String convertToRoman(int val) {
		String res = "";
		String huns[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String tens[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String ones[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		while (val >= 1000) {
			res = res + 'M';
			val -= 1000;
		}

		res = res + huns[val / 100];
		val = val % 100;

		res = res + tens[val / 10];
		val = val % 10;

		res = res + ones[val];
		return res;
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
