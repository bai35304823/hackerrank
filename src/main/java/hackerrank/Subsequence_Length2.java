package hackerrank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.yaml.snakeyaml.Yaml;



public class Subsequence_Length2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(1&2);
		//System.out.println(7&3);
		//System.out.println();
		System.out.println("All Non-empty Subsequences");
		//printSubsequences(arr.length);
		
		ArrayList<Integer> path = new ArrayList<>();
		
		printSubsequences(arr, 0, path);
		
		System.out.println("********************");
		System.out.println(sum);
		//int b = 7&4&3;
		//System.out.println();
		///System.out.println(11&3);
		//System.out.println(List.of(7,4,3).stream().reduce(0, (x, y) ->  x & y));
		Optional<Integer> sss = List.of(11).stream().reduce((x, y) ->  x & y);
		//System.out.println(sss);
////System.out.println(sss.get() );
	}

	
	static int arr[] = new int[]{1, 2, 4,8};
	ArrayList<Integer> ph = new ArrayList<Integer> ();
	private static int sum = 0;
	public static void printSubsequences(int[] arr, int index,
            ArrayList<Integer> path)
			{
			
			// Print the subsequence when reach
			// the leaf of recursion tree
			if (index == arr.length)
			{
			
			// Condition to avoid printing
			// empty subsequence
			if (path.size() > 0)
				System.out.println(path);
			
			/*
			 * for (int j = 0; j < path.size(); j++) {
			 * 
			 * }
			 */
			Optional<Integer> sss = path.stream().reduce((x, y) ->  x & y);
			if (sss.isPresent() && sss.get() != 0) {
			
				 sum = Math.max(sum,path.size());
				 System.out.println("sum -> " +sum);
			};
			
			}
			
			else
			{
			
			// Subsequence without including
			// the element at current index
			printSubsequences(arr, index + 1, path);
			
			path.add(arr[index]);
			
			// Subsequence including the element
			// at current index
			printSubsequences(arr, index + 1, path);
			
			// Backtrack to remove the recently
			// inserted element
			path.remove(path.size() - 1);
			}
			return;
			}
				
    static void printSubsequences(int n)
    {
        /* Number of subsequences is (2**n -1)*/
        int opsize = (int)Math.pow(2, n);
       
        /* Run from counter 000..1 to 111..1*/
        for (int counter = 1; counter < opsize; counter++)
        {
        	 int sum = 0;
            for (int j = 0; j < n; j++)
            {
                /* Check if jth bit in the counter is set
                    If set then print jth element from arr[] */
        
                if (BigInteger.valueOf(counter).testBit(j))
                    System.out.print(arr[j]+" ");
                sum = Math.max(sum, j);
            }
            System.out.println();
        }
}
    }
