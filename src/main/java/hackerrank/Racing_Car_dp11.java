package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
//https://leetcode.com/problems/minimum-sideway-moves/solutions/1152455/java-c-python-dp-greedy-bonus/?orderBy=most_votes
public class Racing_Car_dp11 {
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
	 * From a lane frog can move to two lanes,
	 * +1 for next lane and +2 for next to next lane,
	 * dp[i] determined by  dp[(i + 1) % 3], dp[(i + 2) % 3], see details in code
	 */
	static int minimumMovement(List<Integer> list) {

		int[] obstacles = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

		if (obstacles.length == 0) {
			return 0;
		}
		// Initialization is a boundary case
		// obstacle with a large value
		/*
         * Here calculating minimum moves required to reach current lane from other two lanes.
         * Since Frog starts at middle lane Lane2 so moves array has been initialized with { 1 (lane 1), 0 (lane 2), 1 (lane 3)}
         * Why: Frog starts at lane 2 so how many moves it needs to reach
         * a). lane 1 : 1 move
         * b). lane 2 : 0 move
         * a). lane 3 : 1 move
         * */
		  int[] dp = new int[]{1, 0, 1};
		  
	        for (int a: obstacles) { /* obstacle array also represents length of lanes */
	            if (a > 0) /* if obstacle found */
	                dp[a - 1] = 1000000; /* Set move to very large number. */
	            for (int i = 0; i < 3; ++i)
					/*
					 * Frog moves forward and when it encounters an obstacle it moves. That is why
					 * when an obstacle is encountered we are setting value in move array to large
					 * value (1000000).
					 */
	            	if (a == i + 1)
	            		/* From a lane frog can move to two lanes
	                     * +1 for next lane and +2 for next to next lane
	                     * If currentLane +1 or +2 > 3 then module by 3 will give correct index of lane.
	                     * We have 3 lanes : lane1 (index 0 of moves array), lane2 (index 1 of moves array), lane2 (index 2 of moves array)
	                     * So if frog is at lane 1 (index = 0 ) then next two lanes index are : (0+1) % 3 = 1, (0+2) % 3 = 2
	                     *    if frog is at lane 2 (index = 1 ) then next two lanes index are : (1+1) % 3 = 2, (1+2) % 3 = 0
	                     *    if frog is at lane 3 (index = 2 ) then next two lanes index are : (2+1) % 3 = 0, (2+2) % 3 = 1
	                     * It is like a circular list, move ahead by +1 and +2 index.
	                     * */
	                    dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1);
	        }
	        return Math.min(dp[0], Math.min(dp[1], dp[2]));

	}

	public static void main(String[] args) {

		// sample case 0
		// output: 1
		System.out.println(minimumMovement(List.of(2,1,2)));

		// sample case 1
		// output: 2
		System.out.println(minimumMovement(List.of(2, 1, 3,2)));
		
		// test case actual 0
		// output: 2
		System.out.println(minimumMovement(List.of(2, 3, 2, 1,3,1)));
		
		// test case actual 1
		// output: 2
		System.out.println(minimumMovement(List.of(2, 1, 3, 3,3,1)));
		
		// test case actual 2
		// output: 2
		System.out.println(minimumMovement(List.of(3, 2, 2, 1,2,1)));
	
	}
}
