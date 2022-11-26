package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class closest_numbers {
	 public static List<Integer> closestNumbers(List<Integer> arr) {
	        arr.sort((a,b) -> a.compareTo(b));
	        int minDiff = Integer.MAX_VALUE;
	        for(int i=1;i<arr.size();i++) minDiff = Math.min(minDiff,  arr.get(i) - arr.get(i-1));
	        List<Integer> res = new ArrayList<>();
	        for(int i=1;i<arr.size();i++) if(arr.get(i) - arr.get(i-1) == minDiff) {
	            res.add(arr.get(i-1));
	            res.add(arr.get(i));
	        } 
	        return res;
	    }
	 
	 
}
