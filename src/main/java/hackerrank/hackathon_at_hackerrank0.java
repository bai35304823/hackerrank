package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class hackathon_at_hackerrank0 {

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
	
	
	public static int equalizeTeamSize(List<Integer> list, int k) {
		int[] arr = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

		if (arr.length == 0) {
			return 0;
		}
		int result = Math.min(arr.length, k);
		boolean [] vistied = new boolean[arr.length];
		Arrays.fill(vistied, Boolean.FALSE);
		
		for (int i = 0; i < arr.length; ++i) {
			if (vistied[i] == true) continue;
			int count = 1;
			int great_than_count = 0;
			// j = i + 1;
			for (int j = i + 1;j <arr.length; ++j) {
				if (arr[i] == arr[j]) {
					count++;
					vistied[j] = true;
				} else if (arr[i] < arr[j]) {
					great_than_count++;
				}
			}
			
			//System.out.println(arr[i] +"|"+ count);
			
			result = Math.max(result, count + Math.min(k, great_than_count));
		}
		return result;
	}
}
