package hackerrank;
import java.util.Arrays;

public class Help_Mario_2 {

	public static void main(String[] args) {
		// sample case in question
		// output: 4
		System.out.println(area(6,6,new int[]{4},new int[]{4}));
		
		// sample case 0
		// output: 4
		System.out.println(area(3,3,new int[]{2},new int[]{2}));
		
		// sample case 1
		// output: 4
		System.out.println(area(2,2,new int[]{1},new int[]{2}));
		
		// sample case 2
		// output: 12
		System.out.println(area(3,2,new int[]{1,2,3},new int[]{1,2}));
		
		// sample case x
		// output: 22
		System.out.println(area(10,3,new int[]{1,2,3,4,5,6,7,8,9,10},new int[]{2}));
	}
	
	// MaxArea = (maxRowDistance+1) * (maxColDistance+1)
	// The question can convert to looking for max consecutive 
	// horizontal/vertical bar removals.
	// Q: Find max consecutive subarray for input array?
	public static int max_consecutive_length(int [] arr) {
		Arrays.sort(arr);
		int dp[] = new int[arr.length];
		dp[0] = 1;
		int l = 1;
		for (int i = 1 ; i< arr.length ;++i) {
			for (int j = 0 ; j< i ;++j) {
				if (arr[i] == arr[j] + 1) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			 l = Math.max(dp[i], l);
		}
		
		return  l;
	}
	
	// lower type can be converted to higher type
	public static long area(int m, int n, int [] h, int [] v) {
		
		return (max_consecutive_length(h) + 1) * (max_consecutive_length(v) + 1);
	}
}
