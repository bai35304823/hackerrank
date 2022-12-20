package hackerrank;
import java.io.*;
//
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/
public class Copy_of_Array_Game {

	// Java program to find min operation
	


		// Function to print minimum operation required to make
		// all elements of an array equal
		static void printMinOp(List<Integer> numbers)
		{
			 int [] arr = numbers.stream().mapToInt(Integer::new).toArray();
			int arraySum, smallest, arr_size = arr.length;
			arraySum = 0;
			smallest = arr[0];
			for (int i = 0; i < arr_size; i++) {
				// If current element is smaller than update smallest
				if (arr[i] < smallest)
					smallest = arr[i];

				// find array sum
				arraySum += arr[i];
			}

			int minOperation = arraySum - arr_size * smallest;

			// Print min operation required
			System.out.println("Minimum Operation = " + minOperation);
		}

		// Driver program to test above functions
		public static void main(String[] args)
		{
			int arr[] = { 5, 6, 2, 4, 3 };
			printMinOp(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		}
	}

	// This code is contributed by Sania Kumari Gupta



