//Step-by-Step Algorithm
//1. Sort the H[] array
//2. Find the maximum length of consecutive numbers in H[]
//3. Do the same for V[]
//4. Compute area using the formula above

import java.util.*;
 
public class LargestAreaAfterBarRemoval {
 
    public static int maxArea(int N, int M, int[] H, int[] V) {

   		validateBars(H, N, "Horizontal");
   		validateBars(V, M, "Vertical");
   
   		int maxH = longestConsecutive(H) + 1;
   		int maxV = longestConsecutive(V) + 1;
   
   		return maxH * maxV;
   	}
   
   	// ---------------- helper methods ----------------
   
   	private static void validateBars(int[] bars, int limit, String type) {
   		if (bars == null)
   			throw new IllegalArgumentException(type + " array is null");
   
   		Set<Integer> seen = new HashSet<>();
   
   		for (int b : bars) {
   			if (b < 1 || b > limit)
   				throw new IllegalArgumentException(type + " bar index out of range: " + b);
   
   			if (!seen.add(b))
   				throw new IllegalArgumentException("Duplicate " + type + " bar: " + b);
   		}
   	}
   
   	private static int longestConsecutive(int[] arr) {
   		if (arr.length == 0)
   			return 0;
   
   		Arrays.sort(arr);
   
   		int max = 1;
   		int curr = 1;
   
   		for (int i = 1; i < arr.length; i++) {
   			if (arr[i] == arr[i - 1] + 1) {
   				curr++;
   				max = Math.max(max, curr);
   			} else {
   				curr = 1;
   			}
   		}
   		return max;
   	}
   
   	public static void main(String[] args) {
   		int[] H1 = { 2 };
   		int[] V1 = { 2 };
   		System.out.println(maxArea(3, 3, H1, V1)); // 4
   
   		int[] H2 = { 1, 2, 3 };
   		int[] V2 = { 1, 2 };
   		System.out.println(maxArea(3,2,H2, V2)); // 12
   		
   		System.out.println(maxArea(6,6,new int[]{4},new int[]{4})); // 4
   		System.out.println(maxArea(3,3,new int[]{2},new int[]{2})); // 4
   		System.out.println(maxArea(2,2,new int[]{1},new int[]{2})); // 4
   		System.out.println(maxArea(3,2,H2, V2)); // 12
   		System.out.println(maxArea(10,3,new int[]{1,2,3,4,5,6,7,8,9,10},new int[]{2})); // 22
   	}
}
