package hackerrank;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Sort_the_Summary {
//https://leetcode.com/discuss/interview-question/1535419/amazon-sort-the-summary
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> groupSort(List<Integer> arr) {
		// This kind of map is keeping the order of the keys by their natural order.
		// in this case natural order is integer natural order
		Map<Integer, Integer> map = new TreeMap<>();
		// Run over the input arr and add to the map only if the key isn't their
		// already.
		// else, increase the value at map[key] by one
		for (Integer currInt : arr) {
			map.put(currInt, map.getOrDefault(currInt, 0) + 1);
		}
		// The next lines is for sorting the map by VALUE
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
		// Now after the map is sorted, create 2-dimesional ArrayList and insert pairs
		// of key and values into it
		return list.stream().map(val -> List.of(val.getKey(), val.getValue())).collect(Collectors.toList());

	}

}
