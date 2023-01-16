package hackerrank;

import java.util.List;

//https://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/
public class Copy_of_Array_Game {

	// Java program to find min operation

	// Function to print minimum operation required to make
	// all elements of an array equal
	static long countMoves(List<Integer> numbers) {
		long[] arr = numbers.stream().mapToLong(Integer::new).toArray();
		long arraySum, smallest, arr_size = arr.length;
		arraySum = 0;
		smallest = arr[0];
		for (int i = 0; i < arr_size; i++) {
			// If current element is smaller than update smallest
			if (arr[i] < smallest)
				smallest = arr[i];

			// find array sum
			arraySum += arr[i];
		}

		long minOperation = arraySum - arr_size * smallest;

		// Print min operation required
		return minOperation;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		// sample case in example
		// output: 7
		System.out.println(countMoves(List.of(3, 4, 6, 6, 3)));

		// sample case 0
		// output: 7
		System.out.println(countMoves(List.of(5, 6, 8, 8, 5)));

		// sample case 1
		// output: 0
		System.out.println(countMoves(List.of(2, 2, 2)));
	}

}
