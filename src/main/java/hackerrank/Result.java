package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minimumMovement' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY obstacleLanes as parameter.
     */

    public static int minimumMovement(List<Integer> obstacleLanes) {
    
        int[] obstacles = Optional.ofNullable(obstacleLanes).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

        if (obstacles.length == 0) {
            return 0;
        }
        // Initialization is a boundary case
        // obstacle with a large value
          int[] dp = new int[]{1, 0, 1};
            for (int a: obstacles) {
                if (a > 0) {
                    dp[a - 1] = 1000000;}
                for (int i = 0; i < 3; ++i) {
                    //if (a != i + 1)
                    if (a != i) {
                        dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1);
                        }
            }
            }
            
            return Math.min(dp[0], Math.min(dp[1], dp[2]));


}

 class Solution {
     void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int obstacleLanesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> obstacleLanes = IntStream.range(0, obstacleLanesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumMovement(obstacleLanes);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
}