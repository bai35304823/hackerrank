package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class G {

	 public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
	            try {
	                return bufferedReader.readLine().replaceAll("\\s+$", "");
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        })
	            .map(String::trim)
	            .map(Integer::parseInt)
	            .collect(Collectors.toList());

	        System.out.println(numbers);
	        //Result.closestNumbers(numbers);

	        bufferedReader.close();
	    }

}
