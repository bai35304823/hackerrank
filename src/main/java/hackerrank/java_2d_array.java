package hackerrank;

import java.util.Scanner;

public class java_2d_array {
	 public static void main(String[] args)
	    {
	        int a[][] = new int[6][6];
	        int maxSum = Integer.MIN_VALUE;
	        try (Scanner scanner = new Scanner(System.in);)
	        {
	            for(int i = 0; i < 6; i++)
	            {
	                for(int j = 0; j < 6; j++)
	                {
	                    a[i][j] = scanner.nextInt();
	                    if (i > 1 && j > 1)
	                    {
	                        int sum =
	                            a[i][j]
	                            + a[i][j-1]
	                            + a[i][j-2]
	                            + a[i-1][j-1]
	                            + a[i-2][j]
	                            + a[i-2][j-1]
	                            + a[i-2][j-2];
	                        if (sum > maxSum) {maxSum = sum;}
	                    }
	                }
	            }
	        }
	        System.out.println(maxSum);
	    }
	 
	 
	 public static void main2(String [] args) {
	        Scanner scan = new Scanner(System.in);
	        int arr[][] = new int[6][6];
	        for (int row = 0; row < 6; row++) {
	            for (int col = 0; col < 6; col++) {
	                arr[row][col] = scan.nextInt();
	            }
	        }
	        scan.close();
	        
	        System.out.println(maxHourglass(arr));
	    }
	    
	    public static int maxHourglass(int [][] arr) {
	        int max = Integer.MIN_VALUE;
	        for (int row = 0; row < 4; row++) {
	            for (int col = 0; col < 4; col++) {
	                int sum = findSum(arr, row, col);
	                max = Math.max(max, sum);
	            }
	        }
	        return max;
	    }
	    
	    private static int findSum(int [][] arr, int r, int c) {
	        int sum = arr[r+0][c+0] + arr[r+0][c+1] + arr[r+0][c+2]
	                                + arr[r+1][c+1] + 
	                  arr[r+2][c+0] + arr[r+2][c+1] + arr[r+2][c+2];
	        return sum;
	    }
}
