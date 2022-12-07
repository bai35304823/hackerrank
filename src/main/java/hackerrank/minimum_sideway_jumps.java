package hackerrank;
//https://leetcode.com/problems/minimum-sideway-jumps/discuss/1152665/JavaC%2B%2BPython-DP-O(1)-space

import java.util.List;

//https://leetcode.com/problems/min-cost-climbing-stairs/discuss/?currentPage=1&orderBy=hot&query=
public class minimum_sideway_jumps {
	public static int minSideJumps(int[] obstacles) {
		/*
		 * jumps[0] = minimum jump to reach lane 1 
		 * jumps[1] = minimum jump to reach lane 2
		 * jumps[2] = minimum jump to reach lane 3
		 */
        int[] jumps = new int[]{1, 0, 1};
       for (int obstacle : obstacles) { /* obstacle array also represents length of lanes */
           if (obstacle > 0) { /* if obstacle found */
               jumps[obstacle - 1] = 1000000; /* Set jump to very large number. */
           }
           for (int currentLane = 0; currentLane < 3; ++currentLane) { /* for each lane calculate jumps */
               if (obstacle == currentLane + 1) { /* if current lane doesn't have obstacle */
                   /* From a lane frog can jump to two lanes
                   * +1 for next lane and +2 for next to next lane
                   * If currentLane +1 or +2 > 3 then module by 3 will give correct index of lane.
                   * We have 3 lanes : lane1 (index 0 of jumps array), lane2 (index 1 of jumps array), lane2 (index 2 of jumps array)
                   * So if frog is at lane 1 (index = 0 ) then next two lanes index are : (0+1) % 3 = 1, (0+2) % 3 = 2
                   *    if frog is at lane 2 (index = 1 ) then next two lanes index are : (1+1) % 3 = 2, (1+2) % 3 = 0
                   *    if frog is at lane 3 (index = 2 ) then next two lanes index are : (2+1) % 3 = 0, (2+2) % 3 = 1
                   * It is like a circular list, move ahead by +1 and +2 index.
                   * */
                   final int lane1 = (currentLane + 1) % 3; /* first lane where frog can jump*/
                   final int lane2 = (currentLane + 2) % 3; /* second lange where frog can jump*/
                   final int lane1Jump = jumps[lane1]; /* current count of jumps taken to reach first lane*/
                   final int lane2Jump = jumps[lane2]; /* current count of jumps taken to reach second lane*/
                   /*
                   * Here calculating minimum jumps required to reach current lane from other two lanes.
                   * Since Frog starts at middle lane Lane2 so jumps array has been initialized with { 1 (lane 1), 0 (lane 2), 1 (lane 3)}
                   * Why: Frog starts at lane 2 so how many jumps it needs to reach
                   * a). lane 1 : 1 jump
                   * b). lane 2 : 0 jump
                   * a). lane 3 : 1 jump
                   * Frog moves froward and when it encounters an obstacle it jumps.
                   * That is why when an obstacle is encountered we are setting value in jump array to large value (1000000).
                   * */
                   jumps[currentLane] = Math.min(jumps[currentLane], Math.min(lane1Jump, lane2Jump) + 1);
                  // jumps[currentLane] = Math.min(jumps[currentLane], Math.min(lane1Jump, lane2Jump) );
               }
           }
       }
       return Math.min(jumps[0], Math.min(jumps[1], jumps[2]));
   }

	/*
	 * For each step, we first determine a lane with an obstacle, and set its number
	 * of jumps to a large number.
	 * 
	 * For every other lane, the number of side jumps is the smallest among:
	 * 
	 * The number of jumps for the current lane, or The number of jums for other
	 * lines plus 1.
	 */
	public static int minSideJumps2(int[] obstacles) {
	    int[] dp = {1000000,1,0,1};
	    for (var i : obstacles) {
	        dp[i] = dp[0];
	        for (var j = 1; j < 4; ++j)
	            if (j != i)
	                for (var k = 1; k < 4; ++k)
	                    dp[j] = Math.min(dp[j], dp[k] + (j == k ? 0 : 1));
	    }
	    return Math.min(dp[1], Math.min(dp[2], dp[3]));
	}
	
	public static void main(String[] args) {
		int[] obstacles = {2,1,3,2};
		int[] obstacles2 = {0,2,1,0,3,0};
		int[] obstacles3 = {0,1,1,3,3,0};
		//System.out.println(minSideJumps(obstacles));
		System.out.println(minSideJumps(new int[] {2, 3, 2, 1,3,1}));
	}
	
	
	public static int minSideJumps_my(int[] obstacles) {
		/*
		 * jumps[0] = minimum jump to reach lane 1 
		 * jumps[1] = minimum jump to reach lane 2
		 * jumps[2] = minimum jump to reach lane 3
		 */
        int[] jumps = new int[]{1, 0, 1};
       for (int obstacle : obstacles) { /* obstacle array also represents length of lanes */
           if (obstacle > 0) { /* if obstacle found */
               jumps[obstacle - 1] = 1000000; /* Set jump to very large number. */
           }
           for (int currentLane = 0; currentLane < 3; ++currentLane) { /* for each lane calculate jumps */
               if (obstacle != currentLane) { /* if current lane doesn't have obstacle */
                   /* From a lane frog can jump to two lanes
                   * +1 for next lane and +2 for next to next lane
                   * If currentLane +1 or +2 > 3 then module by 3 will give correct index of lane.
                   * We have 3 lanes : lane1 (index 0 of jumps array), lane2 (index 1 of jumps array), lane2 (index 2 of jumps array)
                   * So if frog is at lane 1 (index = 0 ) then next two lanes are : (0+1) % 3 = 1, (0+2) % 3 = 2
                   *    if frog is at lane 2 (index = 1 ) then next two lanes are : (1+1) % 3 = 2, (1+2) % 3 = 0
                   *    if frog is at lane 3 (index = 2 ) then next two lanes are : (2+1) % 3 = 0, (2+2) % 3 = 1
                   * It is like a circular list, move ahead by +1 and +2 index.
                   * */
                   final int lane1 = (currentLane + 1) % 3; /* first lane where frog can jump*/
                   final int lane2 = (currentLane + 2) % 3; /* second lange where frog can jump*/
                   final int lane1Jump = jumps[lane1]; /* current count of jumps taken to reach first lane*/
                   final int lane2Jump = jumps[lane2]; /* current count of jumps taken to reach second lane*/
                   /*
                   * Here calculating minimum jumps required to reach current lane from other two lanes.
                   * Since Frog starts at middle lane Lane2 so jumps array has been initialized with { 1 (lane 1), 0 (lane 2), 1 (lane 3)}
                   * Why: Frog starts at lane 2 so how many jumps it needs to reach
                   * a). lane 1 : 1 jump
                   * b). lane 2 : 0 jump
                   * a). lane 3 : 1 jump
                   * Frog moves froward and when it encounters an obstacle it jumps.
                   * That is why when an obstacle is encountered we are setting value in jump array to large value (1000000).
                   * */
                  jumps[currentLane] = Math.min(jumps[currentLane], Math.min(lane1Jump, lane2Jump) + 1);
                 // jumps[currentLane] = Math.min(jumps[currentLane],lane1Jump + 1);
               }
           }
       }
       return Math.min(jumps[0], Math.min(jumps[1], jumps[2]));
   }

}
