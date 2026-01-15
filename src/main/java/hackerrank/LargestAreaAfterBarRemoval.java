//Step-by-Step Algorithm
//1. Sort the H[] array
//2. Find the maximum length of consecutive numbers in H[]
//3. Do the same for V[]
//4. Compute area using the formula above

import java.util.*;
 
public class LargestAreaAfterBarRemoval {
 
    private static int maxConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
 
        Arrays.sort(arr);
 
        int max = 1;
        int count = 1;
 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
 
    public static int largestArea(int[] H, int[] V) {
        int maxH = maxConsecutive(H);
        int maxV = maxConsecutive(V);
 
        return (maxH + 1) * (maxV + 1);
    }
 
    public static void main(String[] args) {
        int[] H1 = {2};
        int[] V1 = {2};
        System.out.println(largestArea(H1, V1)); // 4
 
        int[] H2 = {1, 2, 3};
        int[] V2 = {1, 2};
        System.out.println(largestArea(H2, V2)); // 12
    }
}
