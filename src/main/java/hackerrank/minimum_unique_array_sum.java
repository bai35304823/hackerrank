package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 
 * @score 18/75
 */

public class minimum_unique_array_sum {
	// https://stackoverflow.com/questions/38384537/minimum-unique-array-sum

	static int minUniqueSum(int[] A) {
		Arrays.sort(A);
		int n = A.length;

		int sum = A[0];
		int prev = A[0];

		for (int i = 1; i < n; i++) {
			int curr = A[i];

			if (prev >= curr) {
				curr = prev + 1;
			}
			sum += curr;
			prev = curr;
		}

		return sum;
	}

	public static int calculateMinSumSorted(List<Integer> arr) {
		int[] input = Optional.ofNullable(arr).orElseGet(Collections::emptyList).stream().sorted()
				.mapToInt(Integer::new).toArray();
		if (Objects.isNull(input) || 0 == input.length) {
			return 0;
		}
		double sum = input[0];

		long prev = input[0];
		long cur;

		for (int i = 1; i < input.length; i++) {
			cur = input[i];
			if (cur <= prev) {
				cur = ++prev;
			}
			prev = cur;
			sum += cur;

		}
		return (int) Math.round(sum);
	}

	public static void main(String[] args) {

		// sample case 0
		// output : 6
		System.out.println(calculateMinSumSorted(List.of(1, 2, 2)));

		// sample case 1
		// output : 6
		System.out.println(calculateMinSumSorted(List.of(1, 2, 3)));

		// sample case 2
		// output : 14
		System.out.println(calculateMinSumSorted(List.of(2, 2, 4, 5)));

		// sample case x
		// output : 27
		System.out.println(minUniqueSum(new int[] { 2, 2, 3, 3, 4, 4 }));
		
		// sample case actual
		// output : 28271
		System.out.println(calculateMinSumSorted(List.of(1659,710,710,1730,1808,2043,1613,1841,1328,504,1730,2545,493,879,1441,2043,1613,710,1613,1250)));

	}
}
