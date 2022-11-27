package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class the_restructured_array {
	public static int[][] monoToBidi( final int[] array, final int rows, final int cols ) {
	    if (array.length != (rows*cols))
	        throw new IllegalArgumentException("Invalid array length");

	    int[][] bidi = new int[rows][cols];
	    for ( int i = 0; i < rows; i++ )
	        System.arraycopy(array, (i*cols), bidi[i], 0, cols);

	    return bidi;
	}
	public static List<Integer> getElement(List<Integer> arry, List<List<Integer>> query) {
		int[][] query_a = query.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
		int lengtg = arry.stream().findFirst().get();
		List<Integer> l = new  ArrayList<>();
		 int[] input = Optional.ofNullable(arry)
				 .orElseGet(Collections::emptyList)
				 .stream().skip(1)
				 .mapToInt(Integer::new)
				 .toArray();
				
				 
				 int[][] twoD_arr = monoToBidi( input, (arry.size() - 1)/lengtg, lengtg );
				 
				
				 query.forEach(s -> {
					
						l.add(twoD_arr[s.get(0)-1][s.get(1)-1]);
				 } );
				
				
				 
				 return l;	           
		
	}
}
