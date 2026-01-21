///The condition:

//There must NOT exist j < i < k such that height[j] > height[i] and height[k] > height[i]

//means:

//👉 No building can be strictly lower than both some building on its left and some building on its right.

//Equivalently:

//The height array must form a single peak (or be monotonic).
//Heights can increase, then (optionally) decrease, but cannot go down and then up again.

//This is exactly a mountain-shaped array (also called unimodal).

//Strategy

//We choose a peak index p, and:

//From p going left: heights must be non-increasing

//From p going right: heights must be non-increasing

//Each height must be ≤ maxHeight[i]

//Maximize total sum

//How to compute efficiently
//Step 1: Fix a peak at index p

//Set:

//height[p] = maxHeight[p]

//Step 2: Go left

    //For i = p-1 … 0:
    
    //height[i] = min(maxHeight[i], height[i+1])

//Step 3: Go right

    //For i = p+1 … n-1:
    
    //height[i] = min(maxHeight[i], height[i-1])


//This gives the maximum possible sum for that peak.

public class MaxBuildingHeight {

    public static long maxTotalHeight(int[] maxHeight) {
        int n = maxHeight.length;
        long answer = 0;

        for (int peak = 0; peak < n; peak++) {
            long sum = 0;

            int curr = maxHeight[peak];
            sum += curr;

            // Go left
            int leftHeight = curr;
            for (int i = peak - 1; i >= 0; i--) {
                leftHeight = Math.min(leftHeight, maxHeight[i]);
                sum += leftHeight;
            }

            // Go right
            int rightHeight = curr;
            for (int i = peak + 1; i < n; i++) {
                rightHeight = Math.min(rightHeight, maxHeight[i]);
                sum += rightHeight;
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] maxHeight = {5, 10, 5, 10, 5};
        System.out.println(maxTotalHeight(maxHeight)); // 30
    }
}
