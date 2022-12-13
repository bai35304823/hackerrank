package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author m
 */
public class MultiArray {

	public static String checkEvenOrOdd(int[] array) {
		List<Integer> evenLst = new ArrayList<Integer>();
		List<Integer> oddLst = new ArrayList<Integer>();
		int even = 0, odd = 0;
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				evenLst.add(array[i]);
			} else {
				oddLst.add(array[i]);
			}
		}

		// Even List
		for (int i = 0; i < evenLst.size(); i++) {
			if (i % 2 == 0) {
				even += evenLst.get(i);
			} else {
				even *= evenLst.get(i);
			}
		}

		// Odd List
		for (int j = 0; j < oddLst.size(); j++) {
			if (j % 2 == 0) {
				odd += oddLst.get(j);
			} else {
				odd *= oddLst.get(j);
			}
		}

		int evenX = even % 2;
		int oddY = odd % 2;

		if (evenX < oddY) {
			return "ODD";
		} else if (evenX > oddY) {
			return "EVEN";
		}
		return "NEUTRAL";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test Case 1
		// Even
		// int[] inputArray = new int[] {1,2,3,4,5,6,7,8,9,10};

		// Test Case 2
		// Neutral
		// int[] inputArray = new int[] {12,3,5,7,13,12};

		// Test Case 3
		// Neutral
		int[] inputArray = new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };

		System.out.println(checkEvenOrOdd(inputArray));
	}
}
