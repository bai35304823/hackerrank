package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author m
 * @test-case-pass 13/15
 */
public class Server_Selection02 {

	// https://houbb.github.io/2020/01/23/data-struct-learn-07-base-dp
	// https://zhuanlan.zhihu.com/p/37822898
	// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
	// https://www.quora.com/Given-an-array-N-of-integers-how-do-you-check-if-it-is-possible-to-obtain-a-sum-of-S-by-choosing-some-or-zero-elements-of-the-array-and-adding-them

	// https://stackoverflow.com/questions/68401457/minimum-count-of-numbers-required-from-given-array-to-represent-s
	static int getMinServerLength(int sum, List<Integer> list) {
		int[] elems = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();
		int[] minElems = new int[sum + 1];
		for (int i = 1; i <= sum; i++)
			minElems[i] = Integer.MAX_VALUE;
		for (int elem : elems)
			for (int i = sum; i >= elem; i--)
				if (minElems[i - elem] != Integer.MAX_VALUE)
					minElems[i] = Math.min(minElems[i], minElems[i - elem] + 1);
		return minElems[sum] == Integer.MAX_VALUE ? -1 : minElems[sum];
	}

	// Driver code
	public static void main(String args[]) {
		// sample case in question
		// output: 2
		System.out.println(getMinServerLength(3, List.of(1, 1, 2, 4)));

		// sample case 0
		// output: 3
		System.out.println(getMinServerLength(10, List.of(1, 1, 2, 4, 4)));

		// sample case 1
		// output: -1
		System.out.println(getMinServerLength(4, List.of(1, 1, 1)));

		// sample case custom
		// output: 4
		System.out.println(getMinServerLength(10, List.of(2, 2, 2, 2, 4)));

	}

}
