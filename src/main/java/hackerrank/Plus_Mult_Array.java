package hackerrank;

//https://leetcode.com/discuss/interview-question/516429/dream11-oa-2020-plus-mult-array-paths-in-warehouse-final-discounted-price
public class Plus_Mult_Array {
	
	static String plusMult(int[] num) {

		int n = num.length;
		int oddSum = 0;
		int evenSum = 0;
		int x = 0;
		int y = 0;

		for (int i = 0; i < n; i++) {
			// if i is even
			if ((i & 1) == 0) {
				if (x % 2 == 0) {
					evenSum += num[i];
					x++;
				} else {
					evenSum *= num[i];
					x++;
				}
			} else {
				if (y % 2 == 0) {
					oddSum += num[i];
					y++;
				} else {
					oddSum *= num[i];
					y++;
				}
			}
		}
		int even = Math.abs(evenSum % 2);
		int odd = Math.abs(oddSum % 2);
		if (even > odd) {
			return "EVEN";
		} else if (even < odd) {
			return "ODD";
		}
		return "NEUTRAL";

	}
	
	public static void main(String[] args) {

		// sample case in question
		// output : NEUTRAL
		System.out.println(plusMult(new int[] {12, 3, 5,7,13,12}));

		// sample case 0
		// output : EVEN
		System.out.println(plusMult(new int[] {1, 2, 3, 4,5,6,7,8,9,10}));

		// sample case 1
		// output : NEUTRAL
		System.out.println(plusMult(new int[] {1, 3, 5,7,9,11,13,15,17,19}));
		

	}
}
