package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

//https://leetcode.com/problems/minimum-sideway-jumps/solutions/1152455/java-c-python-dp-greedy-bonus/?orderBy=most_votes
public class Racing_Car_dp33 {
	/*
	 * DP
	 * 
	 * dp[0] = minimum move to reach lane 1 
	 * dp[1] = minimum move reach lane 2 
	 * dp[2] = minimum move reach lane 3
	 * 
	 * If meet a obstacle, set its dp[i] to infinity. result equals to min(dp)
	 * 
	 * For each step, we first determine a lane with an obstacle, and set its number
	 * of move to a large number.
	 * 
	 * For every other lane, the number of side move is the smallest among:
	 * 
	 * The number of move for the current lane, or The number of move for other
	 * lines plus 1.
	 */
	static int minimumMovement(List<Integer> list) {

		int[] obstacles = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i)
				.toArray();

		if (obstacles.length == 0) {
			return 0;
		}
		// Initialization is a boundary case
		// obstacle with a large value
		int[] dp = new int[] { 1, 0, 1 };

		for (int i = 0; i < obstacles.length; i++) {
			switch (obstacles[i]) {
			case 1:
				dp[0] = Integer.MAX_VALUE;
				dp[1] = min(dp[1], dp[2] + 1);
				dp[2] = min(dp[1] + 1, dp[2]);
				break;
			case 2:
				dp[0] = min(dp[0], dp[2] + 1);
				dp[1] = Integer.MAX_VALUE;
				dp[2] = min(dp[0] + 1, dp[2]);
				break;
			case 3:
				dp[0] = min(dp[0], dp[1] + 1);
				dp[1] = min(dp[0] + 1, dp[1]);
				dp[2] = Integer.MAX_VALUE;
				break;
			}
		}
		return min(dp[0], dp[1], dp[2]);

	}

	static int min(int... vals) {
		int min = Integer.MAX_VALUE;
		for (int val : vals) {
			if (val >= 0)
				min = Math.min(min, val);
		}
		return min;
	}

	public static void main(String[] args) {
		// sample case 0
		// output: 1
		System.out.println(minimumMovement(List.of(2, 1, 2)));

		// sample case 1
		// output: 2
		System.out.println(minimumMovement(List.of(2, 1, 3, 2)));

		// test case actual 0
		// output: 2
		System.out.println(minimumMovement(List.of(2, 3, 2, 1, 3, 1)));

		// test case actual 1
		// output: 2
		System.out.println(minimumMovement(List.of(2, 1, 3, 3, 3, 1)));

		// test case actual 2
		// output: 2
		System.out.println(minimumMovement(List.of(3, 2, 2, 1, 2, 1)));
	}
}
