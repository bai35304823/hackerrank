package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
//https://leetcode.com/problems/minimum-sideway-jumps/solutions/1152455/java-c-python-dp-greedy-bonus/?orderBy=most_votes
public class Racing_Car_dp2 {
	/*
	 * DP 
	 * 
	 * dp[0] = minimum move to reach lane 1
	 * dp[1] = minimum move reach lane 2
	 * dp[2] = minimum move reach lane 3
	 * 
	 * If meet a obstacle, set its dp[i] to infinity.
	 * result equals to min(dp)

	 * For each step, we first determine a lane with an obstacle, and set its
	 * number of move to a large number.
	 * 
	 * For every other lane, the number of side move is the smallest among:
	 * 
	 * The number of move for the current lane, or The number of move for other
	 * lines plus 1. 
	 */
	static int minimumMovement(List<Integer> list) {

		int[] obstacles = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

		if (obstacles.length == 0) {
			return 0;
		}
		// Initialization is a boundary case
		// obstacle with a large value
		int[] dp = {1000000,1,0,1};
	    for (int i : obstacles) {
	        dp[i] = dp[0];
	        for (int j = 1; j < 4; ++j)
	        	//if (j != i)
	            if (j - 1 != i)
	                for (int k = 1; k < 4; ++k)
	                    dp[j] = Math.min(dp[j], dp[k] + (j == k ? 0 : 1));
	    }
	    return Math.min(dp[1], Math.min(dp[2], dp[3]));

	}

	public static void main(String[] args) {

		// sample case 0
		// output: 1
		//System.out.println(minimumMovement(List.of(1,2,3)));

		// sample case 1
		// output: 2
		System.out.println(minimumMovement(List.of(2, 1, 3)));
		
		// test case 1
		// output: 2
		//System.out.println(minimumMovement(List.of(2, 3, 2, 1,3,1)));
	}
}
