package hackerrank;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://leetcode.com/discuss/interview-question/1595526/Walmart-Hackerrank-Assesment-Question
public class hackathon_at_hackerrank {
	public static int equalizeTeamSize(List<Integer> arr, int k){
		// System.out.println(arr);
		// System.out.println(arr.stream()
					//.skip(1).collect(Collectors.toList()));
		Map<Integer, Long> r = arr.stream()
				//.skip(1)
				.collect(Collectors.groupingBy(
	                     Function.identity(), Collectors.counting()
	             ));
		
		Map<Integer, Long> result = r.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		 int firstKey = result.keySet().stream().findFirst().get();
		 long firstV =  result.get(firstKey);
			
		return Math .min((int)firstV + k, arr.size());
	}
}
