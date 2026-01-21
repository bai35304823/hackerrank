//Optimal strategy (Greedy)

//Put all item quantities into a max-heap (priority queue).

//For each of the m customers:

//Take the item type with the largest remaining quantity.

//Add that quantity to the total revenue.

//Decrease that quantity by 1.

//If it’s still > 0, push it back into the heap.

//This guarantees maximum revenue.
import java.util.PriorityQueue;
import java.util.Collections;

public class MaxRevenue {

    public static long maxRevenue(int[] quantity, int m) {
        // Max heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add initial quantities
        for (int q : quantity) {
            if (q > 0) {
                maxHeap.offer(q);
            }
        }

        long revenue = 0;

        // Process each customer
        for (int i = 0; i < m; i++) {
            if (maxHeap.isEmpty()) {
                break;
            }

            int curr = maxHeap.poll();
            revenue += curr;

            curr--; // one item sold
            if (curr > 0) {
                maxHeap.offer(curr);
            }
        }

        return revenue;
    }

    // Example usage
    public static void main(String[] args) {
        int[] quantity = {1, 2, 4};
        int m = 4;
        System.out.println(maxRevenue(quantity, m)); // Output: 11
    }
}
