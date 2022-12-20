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
	 * Then, transition of one state to another state will be as follows: Find
	 * indexj such that j < i and a[j] & a[i] ! = 0 . Therefore, Dp(i) =
	 * max(Dp(j)+1, Dp(i)) Follow the steps below to solve the problem:
	 * 
	 * Initialize an integer, say ans, to store the length of the longest
	 * subsequence and an array, say dp[], to store the dp states. Define base
	 * caseas dp[0] = 1. Iterate over the range [1, N – 1]: Iterate over the range
	 * [0,i-1] and update dp[i] as max(dp[i], dp[j] + 1) if a[i] & a[j] ! 0. Update
	 * ans as max(ans, dp[i]). Finally, print the maximum length of the longest
	 * subsequence ans.
	 * 
	 * Time Complexity: O(N2) Auxiliary Space: O(N)
	 */
	static int getMinServerLengt11h(int load, List<Integer> list) {

		int[] nums = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

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

	static int getMinServerLength(int load, List<Integer> list) {
		int[] nums = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

		if (nums.length == 0) {
			return 0;
		}
		int m = nums.length;
		int n = load;
		// int [][]table = new int[nums.length + 1][load];

		int[][] table = new int[m + 1][n + 1];

		// Loop to initialize the array
		// as infinite in the row 0
		for (int i = 1; i <= n; i++) {
			table[0][i] = Integer.MAX_VALUE - 1;
		}

		// Loop to find the solution
		// by pre-computation for the
		// sequence
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (nums[i - 1] > j) {
					table[i][j] = table[i - 1][j];
				} else {

					// Minimum possible for the
					// previous minimum value
					// of the sequence
					table[i][j] = Math.min(table[i - 1][j], table[i][j - nums[i - 1]] + 1);
				}
			}
		}
		return table[m][n];
	}

	static int sum(int[] arr) {
		int sum = 0; // initialize sum
		int i;

		// Iterate through all elements and add them to sum
		for (i = 0; i < arr.length; i++)
			sum += arr[i];

		return sum;
	}

	static int getMinServerLength2(int load, List<Integer> list) {
		int[] nums = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

		if (nums.length == 0) {
			return 0;
		}

		if (sum(nums) < load) {
			return -1;
		}
		int m = nums.length;
		int n = load;
		// int [][]table = new int[nums.length + 1][load];

		// dp[i][j] - the minimum number of elements among first i elements which sum is
		// j
		int[][] table = new int[m + 1][n + 1];

		// Loop to initialize the array
		// as infinite in the row 0
		for (int i = 1; i <= n; i++) {
			table[0][i] = Integer.MAX_VALUE - 1;
		}

		// Loop to find the solution
		// by pre-computation for the
		// sequence
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (nums[i - 1] > j) {
					table[i][j] = table[i - 1][j];
				} else {

					// Minimum possible for the
					// previous minimum value
					// of the sequence
					table[i][j] = Math.min(table[i - 1][j], table[i][j - nums[i - 1]] + 1);
				}
			}
		}
		return table[m][n];
	}
	//https://houbb.github.io/2020/01/23/data-struct-learn-07-base-dp
	//https://zhuanlan.zhihu.com/p/37822898
	//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
	//https://www.quora.com/Given-an-array-N-of-integers-how-do-you-check-if-it-is-possible-to-obtain-a-sum-of-S-by-choosing-some-or-zero-elements-of-the-array-and-adding-them
	
	//https://stackoverflow.com/questions/68401457/minimum-count-of-numbers-required-from-given-array-to-represent-s
	static int minElementsForSum(int sum, List<Integer> list){
		int[] elems =Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();
		/*if (sum(elems) < sum) {
			return -1;
		}*/
		int[] minElems = new int[sum + 1];
	    for(int i = 1; i <= sum; i++) minElems[i] = Integer.MAX_VALUE;
	    for(int elem: elems) 
	        for(int i = sum; i >= elem; i--) 
	            if(minElems[i - elem] != Integer.MAX_VALUE) 
	              minElems[i] = Math.min(minElems[i], minElems[i - elem] + 1);
	    return minElems[sum] == Integer.MAX_VALUE ? -1 : minElems[sum] ;
	}
	public static void main(String[] args) {

		// output: 1
		//System.out.println(minElementsForSum(3, List.of(1, 1, 2, 4)));
		// sample case in question
		// output: 3
		System.out.println(minElementsForSum(5, List.of(2, 2, 2, 2, 4)));

		// sample case 0
		// output: 4
		//System.out.println(minElementsForSum(4, List.of(1, 1, 1)));

		// sample case 1

	}
}
