package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 
 * @author
 * @score 50/50
 */
public class The_restructured_array {

	public static List<Integer> getElement(List<Integer> arry, List<List<Integer>> query) {
		// handle null == {arry}
		arry = ofEmptyList(arry);
		query = ofEmptyList(query);
		// the 1st element in {arry} represent length of each row of the 2D array
		int lengtg = arry.stream().findFirst().get();

		List<Integer> results = new ArrayList<>();
		int[] input = arry.stream().skip(1).mapToInt(Integer::new).toArray();

		int[][] twoD_arr = monoToBidi(input, (arry.size() - 1) / lengtg, lengtg);

		query.forEach(s -> {
			if (Objects.isNull(s)) {
				return;
			}
			// int query[q][2] : the row and column positions queried
			// row location= s.get(0) - 1
			// column location = s.get(1) - 1
			//
			// eg, [4,1] -> twoD_arr[3][0]
			results.add(twoD_arr[s.get(0) - 1][s.get(1) - 1]);
		});

		return results;

	}

	// Here a generic function to convert from 1D -> 2D array:
	public static int[][] monoToBidi(final int[] array, final int rows, final int cols) {
		if (array.length != (rows * cols))
			throw new IllegalArgumentException("Invalid array length");

		int[][] bidi = new int[rows][cols];
		for (int i = 0; i < rows; i++)
			System.arraycopy(array, (i * cols), bidi[i], 0, cols);

		return bidi;
	}

	// do the contrary (convert from 2D -> 1D array)
	public static int[] bidiToMono(final int[][] array) {
		int rows = array.length, cols = array[0].length;
		int[] mono = new int[(rows * cols)];
		for (int i = 0; i < rows; i++)
			System.arraycopy(array[i], 0, mono, (i * cols), cols);
		return mono;
	}

	public static final <T> List<T> ofEmptyList(List<T> list) {
		return Optional.ofNullable(list).orElseGet(Collections::emptyList);
	}

	public static void main(String[] args) {
		// Sample case in question
		// output : List.of(1, 2, 6, 7)
		System.out.println(getElement(List.of(5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
				List.of(List.of(1, 1), List.of(1, 2), List.of(2, 1), List.of(2, 2))));

		// Sample case 0
		// output : List.of(10,5)
		System.out.println(
				getElement(List.of(4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), List.of(List.of(3, 2), List.of(2, 1))));
		// Sample case 1
		// output : List.of(44,78,-14,4)
		System.out.println(getElement(List.of(2, 4, 1, 34, 12, -33, 78, 44, 65, -14, -922),
				List.of(List.of(4, 1), List.of(3, 2), List.of(5, 1), List.of(1, 1))));

	}
}
