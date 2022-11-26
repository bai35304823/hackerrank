package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


//https://leetcode.com/problems/minimum-sideway-jumps/
//搜索思想——DFS & BFS（基础基础篇）
public class Racing_Car { // refer minimum-sideway-jumps
	//https://leetcode.com/problems/race-car/discuss/?currentPage=1&orderBy=hot&query=
//https://zhuanlan.zhihu.com/p/24986203
	
	
	//https://www.cnblogs.com/grandyang/p/10360655.html
	
	
	//---Racing_Car --Trail
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
	
	
	//---BFS M1
	public int racecar(int target) {
	    Deque<int[]> queue = new LinkedList<>();
	    queue.offerLast(new int[] {0, 1}); // starts from position 0 with speed 1
	    
	    Set<String> visited = new HashSet<>();
	    visited.add(0 + " " + 1);
	    
	    for (int level = 0; !queue.isEmpty(); level++) {
	        for(int k = queue.size(); k > 0; k--) {
	            int[] cur = queue.pollFirst();  // cur[0] is position; cur[1] is speed
	            
	            if (cur[0] == target) {
	                return level;
	            }
	            
	            int[] nxt = new int[] {cur[0] + cur[1], cur[1] << 1};  // accelerate instruction
	            String key = (nxt[0] + " " + nxt[1]);
	            
	            if (!visited.contains(key) && 0 < nxt[0] && nxt[0] < (target << 1)) {
	                queue.offerLast(nxt);
	                visited.add(key);
	            }
	            
	            nxt = new int[] {cur[0], cur[1] > 0 ? -1 : 1};  // reverse instruction
	            key = (nxt[0] + " " + nxt[1]);
	            
	            if (!visited.contains(key) && 0 < nxt[0] && nxt[0] < (target << 1)) {
	                queue.offerLast(nxt);
	                visited.add(key);
	            }
	        }
	    }
	    
	    return -1;
	}
	
	//---BFS M2
	 private ArrayDeque<int[]> infoQueue;
	    private Map<Integer, Integer> visited;

	    public int racecar2(int target) {
	        this.infoQueue = new ArrayDeque<>();
	        this.visited = new HashMap<>();

	        infoQueue.offer(new int[]{0,0,1}); // init operations = 0, position = 0, speed = 1

	        while(infoQueue.size() > 0) {
	            int[] curInfo = infoQueue.poll();
	            int operations = curInfo[0];
	            int position = curInfo[1];
	            int speed = curInfo[2];
	            
	            if (position == target) {
	                return operations;
	            } 
	            if (visited.containsKey(position) && visited.get(position) == speed) {
	                continue;
	            }
	            visited.put(position, speed);
	            infoQueue.offer(new int[]{operations + 1, position + speed, speed * 2 });
	            if ((position + speed > target && speed > 0) || (position + speed < target && speed < 0)) {
	                infoQueue.offer(new int[]{operations + 1, position, speed > 0 ? -1: 1 });
	            }
	        }
	        return 0;
	    }
}
