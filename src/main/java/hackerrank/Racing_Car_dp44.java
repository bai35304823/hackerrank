package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
// https://leetcode.com/problems/minimum-sideway-jumps/solutions/1152455/java-c-python-dp-greedy-bonus/?orderBy=most_votes
// https://leetcode.com/problems/min-cost-climbing-stairs/
public class Racing_Car_dp44 {

	static int minimumMovement(List<Integer> list) {

		int[] obstacles = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i)
				.toArray();

		if (obstacles.length == 0) {
			return 0;
		}
		// Initialization is a boundary case
		// obstacle with a large value
		int dp[] = { -1, 1, 0, 1 };

		int prev_obstacle = 0;
		// Bottom-up traversal
		for (int i = 0; i < obstacles.length; i++) {

			int curr_obstacle = obstacles[i];
			dp[curr_obstacle] = Integer.MAX_VALUE;

			// check the current obstacle same with previous obstacle
			if (curr_obstacle != prev_obstacle) {
				dp[prev_obstacle] = Math.min(dp[1], Math.min(dp[2], dp[3])) + 1;
			}
			prev_obstacle = curr_obstacle;
		}

		return Math.min(dp[1], Math.min(dp[2], dp[3]));

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
