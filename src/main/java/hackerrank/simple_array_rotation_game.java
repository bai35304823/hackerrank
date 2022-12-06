package hackerrank;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class simple_array_rotation_game {
	@SuppressWarnings("unchecked")
	static List<Integer> rotation_game(List<Integer> a, List<Integer> rotate) {
		
		int[] a_source = Optional.ofNullable(a)
				.orElseGet(Collections::emptyList)
				.stream().mapToInt(i -> i).toArray();
		
		int[] a_rotate = Optional.ofNullable(rotate)
				.orElseGet(Collections::emptyList)
				.stream().mapToInt(i -> i).toArray();
		
		if (a_source.length == 0 || a_rotate.length == 0) {
			return Collections.EMPTY_LIST;
		}
		
		Deque<Integer> ad = new ArrayDeque<>(a);
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < a_rotate.length; ++i) {
			int move_count = a_rotate[i] % a_source.length;
			for (int j = 0; j < move_count; ++j) {
				ad.addLast(ad.pollFirst());
			}
			result.add(findMaxIndex(ad));
			initializeDeque(ad, a);
		}
		
		return result;
		
	}
	
	static int findMaxIndex(Deque<Integer> queue) {
		Object [] modetracker = queue.toArray();
		int maxIndex = 0;
	    for (int i = 1; i < modetracker.length; i++) {
	    	int newnumber = (int) modetracker[i];
	        if ((newnumber > (int) modetracker[maxIndex])) {
	            maxIndex = i;
	        }
	    }
	    return maxIndex;
	}
	
	static void initializeDeque(Deque<Integer> queue, List<Integer> a) {
		queue.removeAll(queue);
		a.forEach(queue::addLast);
	}
	
	public static void main(String[] args) {
		// sample case in question
		// output : [1, 0, 2, 1]
		System.out.println(rotation_game(List.of(1,2,3), List.of(1,2,3,4)));
		
		// sample case 0
		// output : [2, 0]
		System.out.println(rotation_game(List.of(1,2,4,3), List.of(0,2)));
	}
}
