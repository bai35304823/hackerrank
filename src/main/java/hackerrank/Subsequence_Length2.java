package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Subsequence_Length2 {

	private static int ans = 0;

	static int getMaxLength(List<Integer> list) {
		int[] arr = Optional
				.ofNullable(list)
				.orElseGet(Collections::emptyList)
				.stream()
				.mapToInt(i -> i)
				.toArray();

		ArrayList<Integer> path = new ArrayList<>();

		printSubsequences(arr, 0, path);

		return ans;
	}

	public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {

		// Print the subsequence when reach
		// the leaf of recursion tree
		if (index == arr.length) {

			// Condition to avoid printing
			// empty subsequence
			if (path.size() > 0) {
				//System.out.println(path);
				
				// bitwise AND of all the elements in the list
				Optional<Integer> result_bitwise_and = path.stream().reduce((x, y) -> x & y);
				if (result_bitwise_and.isPresent() && result_bitwise_and.get() != 0) {
					ans = Math.max(ans, path.size());
					// System.out.println("sum -> " + sum);
				};
			}
				
		}

		else {

			// Subsequence without including
			// the element at current index
			printSubsequences(arr, index + 1, path);

			path.add(arr[index]);

			// Subsequence including the element
			// at current index
			printSubsequences(arr, index + 1, path);

			// Backtrack to remove the recently
			// inserted element
			path.remove(path.size() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		// sample case in question
		// output: 3
		System.out.println(getMaxLength(List.of(7, 4, 11, 8, 3)));

		// sample case 0
		// output: 4
		initialize_ans();
		System.out.println(getMaxLength(List.of(3, 1, 6, 2, 2)));

		// sample case 1
		// output: 1
		initialize_ans();
		System.out.println(getMaxLength(List.of(1, 2, 4, 8)));
	}
	
	static void initialize_ans() {
		ans = 0;
	}
}