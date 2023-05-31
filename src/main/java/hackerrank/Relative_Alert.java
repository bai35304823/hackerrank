package hackerrank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Relative_Alert {

	public static void main(String[] args) {
		// sample case in question
		// output: {1,2,3,2}
		System.out.println(ressignedSeverities(List.of(1,4,8,4)));
		
		// sample case 0
		// output: {1,2,3,2}
		System.out.println(ressignedSeverities(List.of(1,3,7,3)));
			
		// sample case 1
		// output: {1,3,2,1,2}
		System.out.println(ressignedSeverities(List.of(2,9,3,2,3)));

	}

	
	
	public static List<Integer> ressignedSeverities(List<Integer> items) {
				
		List<Integer> distinct = items.stream()
				.sorted()
				.distinct()
				.collect(Collectors.toList());
		
		int [] array = new int[100];
		
		for (int i= 0; i < distinct.size(); ++i) {
			array[distinct.get(i)] = i + 1;
		}
		
		List<Integer> list = new ArrayList<>();
		
		items.forEach(o -> {
			list.add(array[o]);
		});
		
		return list;
	
	}
}
