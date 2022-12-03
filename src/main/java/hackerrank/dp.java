package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

//Length of longest subsequence whose XOR value is odd
// https://www.quora.com/How-can-I-find-even-or-odd-using-an-XOR-bitwise-operator
//https://www.geeksforgeeks.org/length-of-longest-subsequence-whose-xor-value-is-odd/?ref=lbp
public class dp {
	static int getMaxLength(List<Integer> list) {

		int[] nums = Optional.ofNullable(list)
				.orElseGet(Collections::emptyList)
				.stream().mapToInt(i -> i).toArray();

		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		// Initialization is a boundary case
		dp[0] = 1;
		int maxans = 1;

		// Bottom-up traversal
		for (int i = 1; i < nums.length; i++) {
			// Traverse from 0 to i
			for (int j = 0; j < i; j++) {
				// Find the previous number nums[j] ,that is dp[i]= dp[j]+1 or dp[j]
				if (((nums[i] ^ nums[j]) & 1) != 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} 
				
			}
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans < 2 ? 0 : maxans;

	}
	
	public static void main(String[] args) {

		// sample case in question
		// output: 3
		System.out.println(getMaxLength(List.of(2, 3, 4, 1, 5, 6, 7)));

		// sample case 0
		// output: 4
		System.out.println(getMaxLength(List.of( 2, 3, 4, 5, 6, 7)));

		// sample case 1
		// output: 1
		System.out.println(getMaxLength(List.of( 2, 4, 6,8)));
		System.out.println(2|5);
				//System.out.println((2^3)&1);
		
		System.out.println(15^25);
	}
}
