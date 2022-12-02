package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
//https://www.geeksforgeeks.org/length-of-the-longest-subsequence-such-that-xor-of-adjacent-elements-is-equal-to-k/
public class Subsequence_Length_dp {
	/*
	 * Naive Approach: The idea is to use Dynamic Programming. The given problem can
	 * be solved based on the following observations:
	 * 
	 * Suppose Dp(i) represent maximum length of subsequence ending at index i.
	 * Then, transition of one state to another state will be as follows: 
	 * Find indexj such that j < i and a[j] & a[i] ! = 0 . 
	 * Therefore, Dp(i) = max(Dp(j)+1, Dp(i))
	 * Follow the steps below to solve the problem:
	 * 
	 * Initialize an integer, say ans, to store the length of the longest
	 * subsequence and an array, 
	 * say dp[], to store the dp states. 
	 * Define base caseas dp[0] = 1. 
	 * Iterate over the range [1, N – 1]: 
	 * Iterate over the range [0,i-1] and update dp[i] as max(dp[i], dp[j] + 1) 
	 * if a[i] & a[j] ! 0. 
	 * Update ans as max(ans, dp[i]). 
	 * Finally, print the maximum length of the longest subsequence ans.
	 * 
	 * Time Complexity: O(N2)
	 * Auxiliary Space: O(N)
	 */
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
				if ((nums[i] & nums[j]) != 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} 
				
			}
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;

	}

	public static void main(String[] args) {

		// sample case in question
		// output: 3
		System.out.println(getMaxLength(List.of(7, 4, 11, 8, 3)));

		// sample case 0
		// output: 4
		System.out.println(getMaxLength(List.of(3, 1, 6, 2, 2)));

		// sample case 1
		// output: 1
		System.out.println(getMaxLength(List.of(1, 2, 4, 8)));

	}
}
