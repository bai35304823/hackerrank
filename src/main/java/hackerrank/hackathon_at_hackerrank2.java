package hackerrank;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://leetcode.com/discuss/interview-question/1595526/Walmart-Hackerrank-Assesment-Question
public class hackathon_at_hackerrank2 {
	
	public static int equalizeTeamSize(List<Integer> arr, int k){	
		arr = ofEmptyList(arr);
		// group by each element then count
		Map<Integer, Long> map = arr.stream()
				.collect(Collectors.groupingBy(
	                     Function.identity(), Collectors.counting()
	             ));
		/*
		 * Convert a Map into a Stream 
		 * Sort it by value
		 * Collect and return a new LinkedHashMap (keep the order)
		 */
		Map<Integer, Long> result = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		// get 1st element key and value
		int firstKey = result.keySet().stream().findFirst().get();
		long firstV =  result.get(firstKey);
		
		// if the rest element that great than firstKey's {count} < k, k = min(k, {count})
		long count = arr.stream().filter(e -> e > firstKey).count();
		// if k > arr.size()
		return Math.min((int)firstV + Math.min(k, (int)count), arr.size());
	}
	
	public static void main(String[] args) {
		// Sample case in question
		// output : 4
		System.out.println(equalizeTeamSize(List.of(1, 2, 2, 3, 4), 2));

		// Sample case 0
		// output : 2
		System.out.println(equalizeTeamSize(List.of(1, 7, 3, 8), 1));
		
		// Sample case 1
		// output : 7
		System.out.println(equalizeTeamSize(List.of(1, 2, 3, 4, 5, 6, 7), 10));
		
		// Sample case x
		// output : 5
		System.out.println(equalizeTeamSize(List.of(1, 3, 4, 4, 4, 5, 7), 2));

		// Sample case x
		// output : 4
		System.out.println(equalizeTeamSize(List.of(1, 3, 4, 4, 4, 5), 2));
		
		// Sample case x
		// output : 3
		System.out.println(equalizeTeamSize(List.of(1, 3, 4, 4, 4), 2));
	}
	
	private static int solution3(List<Integer> inputArr) {
	    // Time Complexity O(N)
	    // Space Complexity O(1)
	    // Stream
	    return (int) inputArr.stream()
	            .collect(Collectors
	                    .toMap(Function.identity(), v -> 1, Integer::sum))
	            .entrySet().stream()
	            .filter(k -> k.getValue() >= 2)
	            .count();
	}
	
	public static final <T> List<T> ofEmptyList(List<T> list) {
		return Optional.ofNullable(list).orElseGet(Collections::emptyList);
	}
}
