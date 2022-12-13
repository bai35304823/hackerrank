package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/forum
public class simple_array_rotation_game2 {
// For left it will be int newLoc= (n +(i-k))%n;
// new_index = (i + no_of_left_rotation) % length_of_array

	@SuppressWarnings("unchecked")
	static List<Integer> rotation_game(List<Integer> a, List<Integer> rotate) {

		int[] a_source = Optional.ofNullable(a).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

		int[] a_rotate = Optional.ofNullable(rotate).orElseGet(Collections::emptyList).stream().mapToInt(i -> i)
				.toArray();

		if (a_source.length == 0 || a_rotate.length == 0) {
			return Collections.EMPTY_LIST;
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < a_rotate.length; ++i) {
			result.add(findMaxIndex(rotate(a_source, a_rotate[i])));
		}
		return result;
	}

	static int findMaxIndex(int[] modetracker) {
		int maxIndex = 0;
		for (int i = 1; i < modetracker.length; i++) {
			int newnumber = modetracker[i];
			if (newnumber > modetracker[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	static int[] rotate(int[] arr, int k) {
		int[] arr_new = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int newLocation = (i + k) % arr.length;
			 //System.out.println(arr[newLocation]);
			arr_new[i] = arr[newLocation];
		}
		return arr_new;
	}

	static void swap(int charArray[], int i, int j) {
		int temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}

	public static void main(String[] args) {
		// sample case in question
		// output : [1, 0, 2, 1]
		System.out.println(rotation_game(List.of(1, 2, 3), List.of(1, 2, 3, 4)));

		// sample case 0
		// output : [2, 0]
		System.out.println(rotation_game(List.of(1, 2, 4, 3), List.of(0, 2)));
		
		// rotate(new int[] { 1, 2, 3, 4, 5 }, 4);
	}
}
