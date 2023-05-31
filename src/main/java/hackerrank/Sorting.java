package hackerrank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String[] args) {
		// sample case in question
		// output: {3,6,4,4,5,5}
		System.out.println(sortItem(new int[]{4,5,6,5,4,3}));
		
		// sample case 0
		// output: {1,3,4,2,2}
		System.out.println(sortItem(new int[]{3,1,2,2,4}));
			
		// sample case 1
		// output: {8,4,4,1,1,1,5,5,5,5}
		System.out.println(sortItem(new int[]{8,5,5,5,5,1,1,1,4,4}));
	}
	
	
	public static List<Integer> sortItem(int [] items) {
		Map<Integer, Integer> map = new HashMap<>();
		
		if (Objects.isNull(items) || 0 == items.length) {
			return null;
		}
		for (int i = 0; i < items.length; ++i) {
			map.put(items[i], map.getOrDefault(items[i], 0) + 1);
		}
		
		Map<Integer, Integer> result = map.entrySet()
		.stream()
		.sorted(Map.Entry.<Integer, Integer>comparingByValue()
				.thenComparing(Map.Entry.comparingByKey()))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
				(e1, e2) -> e1, LinkedHashMap::new));
		
		List<Integer> list = new ArrayList<>();
		
		result.forEach((k,v) -> {
			for (int i = 0; i < v; ++i) {
				list.add(k);
			}
		});
		
		
		return list;
		
	}
}
