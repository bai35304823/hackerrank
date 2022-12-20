package hackerrank;

import java.util.List;
import java.util.Vector;

//https://www.geeksforgeeks.org/minimum-number-of-given-powers-of-2-required-to-represent-a-number/?ref=rp
/* Approach: For each power of 2 let’s calculate the number of elements 
 * in the given array with the value equals this. Let’s call it cnt. 
 * It is obvious that we can obtain the value x greedily 
 * (because all fewer values of elements are divisors of 
 * all greater values of elements).
 * Now let’s iterate over all powers of 2 from 30 to 0. 
 * Let’s deg be the current degree. We can take 
 * min(x / 2deg, cntdeg) elements with the value equals 2deg. 
 * Let it be cur. Add cur to the answer and subtract 2deg * cur from x. 
 * Repeat the process until the x can no longer be reduced. If after 
 * iterating over all powers, x is still non-zero then print -1.
 *  Otherwise, print the answer.
 * Below is the implementation of the above approach: */
public class T2 {

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
	
	// __builtin_ctz(a[i]) returns the count
	// of trailing 0s in a[i]
	
	//Integer.numberOfTrailingZeros(int i)
	static int __builtin_ctz(int a)
	{
	    int count = 0;
	    for(int i = 0; i < 40; i++)
	    if(((a >> i) & 1) == 0)
	    {
	        count++;
	    }
	    else
	        break;
	    return count;
	}
	 
	// Function to return the minimum number
	// of given integer powers of 2 required
	// to represent a number as sum of these powers
	static int power_of_two(int n, int a[], int x)
	{
	 
	    // To store the count of powers of two
	    Vector<Integer> cnt = new Vector<Integer>();
	     
	    for (int i = 0; i < 31; ++i)
	        cnt.add(0);
	 
	    for (int i = 0; i < n; ++i)
	    {
	 
	        // __builtin_ctz(a[i]) returns the count
	        // of trailing 0s in a[i]
	         
	        cnt.set(__builtin_ctz(a[i]),
	        (cnt.get(__builtin_ctz(a[i]))==null) ?
	        1 : cnt.get(__builtin_ctz(a[i]))+1);
	    }
	 
	    int ans = 0;
	    for (int i = 30; i >= 0 && x > 0; --i)
	    {
	 
	        // If current power is available
	        // in the array and can be used
	        int need = Math.min(x >> i, cnt.get(i));
	 
	        // Update the answer
	        ans += need;
	 
	        // Reduce the number
	        x -= (1 << i) * need;
	    }
	 
	    // If the original number is not reduced to 0
	    // It cannot be represented as the sum
	    // of the given powers of 2
	    if (x > 0)
	        ans = -1;
	 
	    return ans;
	}
	 
	// Driver code
	public static void main(String args[])
	{
	    int arr[] = { 2, 2, 4, 4, 8 }, x = 6;
	    int n = arr.length;
	    //System.out.println(power_of_two(n, arr, x));
	    
		// output: 1
	    int arr1[] = { 1, 1, 2, 4 };  
	    int x1 = 3;
	    int n1 = arr1.length;
	    System.out.println(power_of_two(n1, arr1, x1));
		//System.out.println(minElementsForSum(3, List.of(1, 1, 2, 4)));
		// sample case in question
		// output: 3
		//System.out.println(minElementsForSum(5, List.of(2, 2, 2, 2, 4)));
		
		//System.out.println(minElementsForSum(10, List.of(1, 1, 2, 4, 4)));
	    
	    int arr2[] = {1, 1, 2, 2, 4 };  
	    int x2 = 8;
	    int n2 = arr2.length;
	    System.out.println(power_of_two(n2, arr2, x2));
		//System.out.println(minElementsForSum(8, List.of(1, 1, 2, 2, 4)));

	    int arr3[] = {1, 1, 1 };  
	    int x3 = 4;
	    int n3 = arr3.length;
	    System.out.println(power_of_two(n3, arr3, x3));
		// sample case 0
		// output: 4
		//System.out.println(minElementsForSum(4, List.of(1, 1, 1)));

		// sample case 1
	    
	    System.out.println(Integer.numberOfTrailingZeros(16) == __builtin_ctz(16));
	    System.out.println(Integer.numberOfTrailingZeros(64) == __builtin_ctz(64));
	    System.out.println(Integer.numberOfTrailingZeros(1024) == __builtin_ctz(1024));
	    System.out.println(Integer.numberOfTrailingZeros(16));
	    
	}

}
