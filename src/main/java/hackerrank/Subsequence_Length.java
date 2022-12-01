package hackerrank;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


/*Time Complexity: O(2N)
Auxiliary Space: O(1)

Efficient Approach: The above approach can also be optimized 
by observing the fact that only those elements 
whose bits are set in all the chosen array elements gives 
the subsequence whose Bitwise AND is non-zero. 

*Initialize a variable, say ans that stores the maximum length 
*of subsequences having the value of Bitwise AND as positive.
*
*Iterate over the range [0, 32] using the variable i and 
*perform the following steps:
*
	*Initialize a variable, say length that stores the length 
	*of all the elements whose ith bit is set.
	*
	*Traverse the given array and if the ith bit is set
	* of the array element arr[i], then add this value to the variable length.
	* 
	*Update the value of ans to the maximum of ans and length.
*
*After completing the above steps, print the value 
*of the sum as the resultant maximum sum of subsequence.





*
*/

public class Subsequence_Length {
	
	/*
	 * Consider an array:
	 * 
	 * {1,2,3,4} 
	 * Subarray: contiguous sequence in an array i.e.
	 * 
	 * {1,2},{1,2,3} 
	 * 
	 * 
	 * Subsequence: Need not to be contiguous, but maintains order
	 * i.e.
	 * 
	 * {1,2,4} 
	 * 
	 * Subset: Same as subsequence except it has empty set i.e.
	 * 
	 * {1,3},{} Given an array/sequence of size n, possible
	 * 
	 * Subarray = n*(n+1)/2 
	 * Subseqeunce = (2^n) -1 (non-empty subsequences) 
	 * Subset =2^n
	 */
	public static int getMaxLength(List<Integer> arr){
		int sum = 0;	
		return printMaxLengthSubsequences(Optional.ofNullable(arr)
				 .orElseGet(Collections::emptyList).stream()
				.mapToInt(i->i)
				.toArray(), sum);
		
	}
	
	
	/*
	 * A subarray or substring will always be contiguous, but a subsequence need not
	 * be contiguous. That is, subsequences are not required to occupy consecutive
	 * positions within the original sequences. But we can say that both contiguous
	 * subsequence and subarray are the same.
	 */
	 static void printSubsequences(int arr[], int sum)
	    {
		 int n = arr.length;
	        /* Number of subsequences is (2**n -1)*/
	        int opsize = (int)Math.pow(2, n);
	       
	        /* Run from counter 000..1 to 111..1*/
	        for (int counter = 1; counter < opsize; counter++)
	        {
	            for (int j = 0; j < n; j++)
	            {
	                /* Check if jth bit in the counter is set
	                    If set then print jth element from arr[] */
	        
	                if (BigInteger.valueOf(counter).testBit(j)) {
	                	System.out.print(arr[j]+" ");
	                }
	                    
	            }
	            System.out.println();

	        }
	    }
	
	 static int printMaxLengthSubsequences(int arr[], int sum)
	    {
		 int n = arr.length;
        /* Number of subsequences is (2**n -1)*/
        int opsize = (int)Math.pow(2, n);
	     // Iterate over all the bits, Type: int -> Size: 32 bits
	      for (int bit = 0; bit < 32; bit++) {
	        /* Run from counter 000..1 to 111..1*/
	        for (int counter = 1; counter < opsize; counter++)
	        {
	            int l = 0;
	        	for (int j = 0; j < n; j++)
	            {
	                /* (arr[j] & (1 << bit)) != 0
	                 * Check if bit-th bit in the arr[j] is set
	                    If set then consider 
	                    whose Bitwise AND is non-zero from arr[] */
	            	// https://stackoverflow.com/questions/41629583/what-does-the-statement-if-counter-1j-mean-and-how-does-it-work
	                if (BigInteger.valueOf(arr[j]).testBit(bit)) {
	                	//System.out.print(arr[j]+" ");
	                	l++;
	                }
	                    
	            }
	            //System.out.println();
	            sum = Math.max(l, sum);
	        }
	      }
		return sum;
	    }
	/*
	 * How to generate all subarrays? We can run two nested loops, the outer loop
	 * picks starting element and inner loop considers all elements on right of the
	 * picked elements as ending element of subarray.
	 */
	 // Prints all subarrays in arr[0..n-1]
	    static void subArray(int []arr )
	    {
	    	int n = arr.length;
	        // Pick starting point
	        for (int i=0; i <n; i++)
	        {
	            // Pick ending point
	            for (int j=i; j<n; j++)
	            {
	                // Print subarray between current starting
	                // and ending points
	                for (int k=i; k<=j; k++)
	                    System.out.print(arr[k]+" ");
	            }
	        }
	    }  
	    
	public static void main(String[] args) {
	  // sample case 0
	  // output: 4
		System.out.println(getMaxLength(List.of(3,1,6,2,2)));
		
		// sample case 1
		  // output: 1
		System.out.println(getMaxLength(List.of(1,2,4,8)));
		
	}

    }
