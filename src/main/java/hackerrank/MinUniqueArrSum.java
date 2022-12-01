package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author m
 * @score 27/75
 */
public class MinUniqueArrSum {

	static int minUniqueSum(List<Integer> lst) {
		int[] arr = Optional.ofNullable(lst)
				 .orElseGet(Collections::emptyList)
				 .stream()
				 .mapToInt(Integer::new)
				 .toArray();
		
		for(int k=0;k<lst.size();k++) {
			arr[k] = lst.get(k);
		}
		
		for(int k=0; k<arr.length; k++) {
			for(int l=k+1; l<arr.length; l++) {
				if(arr[k] == arr[l]) {
					arr[l] = arr[l]+1;
				}
			}
		}

	    int totalResult = 0;
	    for(int i=0;i<arr.length;i++) {
	    	totalResult = totalResult + arr[i];
	    }
		return totalResult;
	}

	
	public static void main(String[] args) {
	
		// sample case 0
		// output : 6
		System.out.println(minUniqueSum(List.of(1,2,2)));
		
		// sample case 1
		// output : 6
		System.out.println(minUniqueSum(List.of(1,2,3)));
		
		// sample case 2
		// output : 14
		System.out.println(minUniqueSum(List.of(2,2,4,5)));
		
	}

}
