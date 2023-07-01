package hackerrank;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//https://www.geeksforgeeks.org/largest-area-possible-after-removal-of-a-series-of-horizontal-vertical-bars/


public class Help_Mario_1 {
	/*Approach: Follow the steps below to solve the problem:

	 * 	Initialize two sets, s1 & s2 to store the integers.
	 * Iterate over the range [1, N+1] and store every integer in s1.
	 * Similarly, iterate over the range [1, M + 1] and store every integer in s2.
	 * Traverse the array H[] and remove all H[i] from s1.
	 * Similarly, traverse the array V[] and remove all V[i] from s2.
	 * Convert updated s1 and s2 sets into lists l1 and l2.
	 * Sort both the lists in ascending order.
	 * Traverse the list l1 and l2 and store the maximum distance between two neighbours as maxH and maxV respectively.
	 * Print the product of maxH and maxV as the largest area.

	 */
	public static void main(String[] args) {
		// sample case in question
		// output: 4
		System.out.println(largestArea(6,6,new int[]{4},new int[]{4}));
		
		// sample case 0
		// output: 4
		System.out.println(largestArea(3,3,new int[]{2},new int[]{2}));
		
		// sample case 1
		// output: 4
		System.out.println(largestArea(2,2,new int[]{1},new int[]{2}));
		
		// sample case 2
		// output: 12
		System.out.println(largestArea(3,2,new int[]{1,2,3},new int[]{1,2}));
		
		// sample case x
		// output: 22
		System.out.println(largestArea(10,3,new int[]{1,2,3,4,5,6,7,8,9,10},new int[]{2}));
	}
	
	 // Function to find the largest area
    // when a series of horizontal &
    // vertical bars are removed
    static long largestArea(int N, int M,
                            int[] H, int[] V)
    {
        // Stores all bars
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
 
        // Insert horizontal bars
        for (int i = 1; i <= N + 1; i++)
            s1.add(i);
 
        // Insert vertictal bars
        for (int i = 1; i <= M + 1; i++)
            s2.add(i);
 
        // Remove horizontal separators from s1
        for (int i = 0; i < H.length; i++) {
 
            s1.remove(H[i]);
        }
 
        // Remove vertical separators from s2
        for (int i = 0; i < V.length; i++) {
 
            s2.remove(V[i]);
        }
 
        // Stores left out horizontal and
        // vertical separators
        int[] list1 = new int[s1.size()];
        int[] list2 = new int[s2.size()];
 
        int i = 0;
        Iterator it1 = s1.iterator();
        while (it1.hasNext()) {
            list1[i++] = (int)it1.next();
        }
 
        i = 0;
        Iterator it2 = s2.iterator();
        while (it2.hasNext()) {
            list2[i++] = (int)it2.next();
        }
 
        // Sort both list in
        // ascending order
        Arrays.sort(list1);
        Arrays.sort(list2);
 
        int maxH = 0, p1 = 0, maxV = 0, p2 = 0;
 
        // Find maximum difference of neighbors of list1
        for (int j = 0; j < list1.length; j++) {
            maxH = Math.max(maxH, list1[j] - p1);
            p1 = list1[j];
        }
 
        // Find max difference of neighbors of list2
        for (int j = 0; j < list2.length; j++) {
            maxV = Math.max(maxV, list2[j] - p2);
            p2 = list2[j];
        }
 
        // Print largest volume
        return maxV * maxH;
    }
}
