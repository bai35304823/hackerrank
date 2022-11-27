package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//import com.sun.jndi.url.rmi.rmiURLContext;

public class minimum_unique_array_sum {
	//https://stackoverflow.com/questions/38384537/minimum-unique-array-sum
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		////List<Integer> arr = List.of(Integer.MAX_VALUE, 2,2,2,3,4,5,6,7,8,9);
		/*
		 * int[] input = Optional.ofNullable(arr) .orElseGet(Collections::emptyList)
		 * .stream() .mapToInt(Integer::new) .toArray();
		 */
		//List<Integer> arr2 = List.of(1659,710,710,1730,1808,2043,1613,1841,1328,504,1730,2545,493,879,1441,2043,1613,710,1613,1250);
				List<Integer> arr3 =  List.of(3,2,1,2,7);
//System.out.println("length" + calculateMinSumSorted( arr));
//System.out.println( calculateMinSumSorted( arr3));
//System.out.println("length" + calculateMinSumSorted( arr3));
		//int[] A = { 3,2,1,2,1,7 };
//List<Integer> arr =List.of(4,1,2,2,3,4,2);
		/*
		 * List<Integer> arrw =List.of(1,2,3,4,5,6,7); //List<Integer> arrws
		 * =List.of(4,1,7,3,8); //List c = new ArrayList(arrws);
		 * System.out.println(equalizeTeamSize(arrw, 10)); ;
		 */


	}

	static int minUniqueSum(int[] A) {
		Arrays.sort(A);
	    int n = A.length;

	    int sum = A[0];
	    int prev = A[0];

	    for( int i = 1; i < n; i++ ) {
	        int curr = A[i];

	        if( prev >= curr ) {
	            curr = prev+1;
	        }
	        sum += curr;
	        prev = curr;
	    }

	    return sum;
	}
	
	
	 public static int calculateMinSumSorted(List<Integer> arr){
		 int[] input = Optional.ofNullable(arr)
				 .orElseGet(Collections::emptyList)
				 .stream().sorted()
				 .mapToInt(Integer::new)
				 .toArray();
		 if (Objects.isNull(input) || 0 == input.length) {
			 return 0;
		 }
		    double sum = input[0];

		    long prev = input[0];
		    long cur;

		    for(int i = 1 ; i < input.length ; i++){
		        cur = input[i];
		        if(cur <= prev){
		            cur = ++prev;
		        }
		        prev = cur;
		        sum += cur;
     
		    }
		    return (int) Math.round(sum);
		}
}
