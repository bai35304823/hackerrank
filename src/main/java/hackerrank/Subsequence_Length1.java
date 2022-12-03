package hackerrank;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Subsequence_Length1 {

	/*
	 * Consider an array:
	 * 
	 * {1,2,3,4} Subarray: contiguous sequence in an array i.e.
	 * 
	 * {1,2},{1,2,3}
	 * 
	 * 
	 * Subsequence: Need not to be contiguous, but maintains order i.e.
	 * 
	 * {1,2,4}
	 * 
	 * Subset: Same as subsequence except it has empty set i.e.
	 * 
	 * {1,3},{} Given an array/sequence of size n, possible
	 * 
	 * Subarray = n*(n+1)/2 Subseqeunce = (2^n) -1 (non-empty subsequences) Subset
	 * =2^n
	 */
	public static int getMaxLength(List<Integer> arr) {

		return printSubsequences(
				Optional.ofNullable(arr)
				.orElseGet(Collections::emptyList).stream()
				.mapToInt(i -> i).toArray());

	}

	/*
	 * A subarray or substring will always be contiguous, but a subsequence need not
	 * be contiguous. That is, subsequences are not required to occupy consecutive
	 * positions within the original sequences. But we can say that both contiguous
	 * subsequence and subarray are the same.
	 */
	static int printSubsequences(int arr[]) {
		int sum = 0;
		int n = arr.length;
		// define a array to save subsequences array
		int[] result = new int[arr.length];
		/* Number of subsequences is (2**n -1) */
		int opsize = (int) Math.pow(2, n);

		/* Run from counter 000..1 to 111..1 */
		for (int counter = 1; counter < opsize; counter++) {
			for (int j = 0; j < n; j++) {
				/*
				 * Check if jth bit in the counter is set If set then print jth element from
				 * arr[]
				 */

				if (BigInteger.valueOf(counter).testBit(j)) {
					// System.out.print(arr[j]+" ");
					result[j] = arr[j];
				}

			}
			// System.out.println();

			// remove zeros subsequences int array
			result = remove_zeros_from_int_array(result);
			// find bitwise AND not equal 0
			if (find_and(result) != 0) {
				// find max length
				sum = Math.max(result.length, sum);
			}
			// clear subsequences array element
			result = new int[arr.length];

		}
		return sum;
	}

	// Java program to find bitwise AND
	// of all the elements in the array
	static int find_and(int arr[]) {
		// Initialise ans variable is arr[0]
		int ans = arr[0];
		// Traverse the array compute AND
		for (int i = 0; i < arr.length; i++) {
			ans = (ans & arr[i]);
		}

		return ans;
	}

	static int[] remove_zeros_from_int_array(int test[]) {
		int n = 0;
		for (int i = 0; i < test.length; i++) {
			if (test[i] != 0)
				n++;
		}

		int[] newArray = new int[n];
		int j = 0;

		for (int i = 0; i < test.length; i++) {
			if (test[i] != 0) {
				newArray[j] = test[i];
				j++;
			}
		}

		return newArray;

	}

	public static void main(String[] args) {

		// sample case in question
		// output: 3
		System.out.println(getMaxLength(List.of(7, 4, 11, 8, 3)));

		// sample case 0
		// output: 4
		System.out.println(getMaxLength(List.of(3, 1, 6, 2, 2)));

		// sample case 1
		// output: 1
		System.out.println(getMaxLength(List.of(1, 2, 4, 8)));

	}

}
