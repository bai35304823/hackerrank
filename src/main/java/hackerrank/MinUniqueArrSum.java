package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author m
 *
 */
public class MinUniqueArrSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lst = new ArrayList<Integer>();
		lst.add(2);
		lst.add(2);
		lst.add(4);
		lst.add(5);
		
		int[] arr = new int[lst.size()];
		
		for(int k=0;k<lst.size();k++) {
			arr[k] = lst.get(k);
		}

		//ArrayList<Integer> resultList = new ArrayList<Integer>();
		for(int k=0; k<arr.length; k++) {
			for(int l=k+1; l<arr.length; l++) {
				if(arr[k] == arr[l]) {
					arr[l] = arr[l]+1;
				}
			}
		}

	    int totalResult = 0;
	    for(int i=0;i<arr.length;i++) {
	    	totalResult = totalResult + arr[i];
	    }
	    System.out.println("sum: "+totalResult);
		
	}

}
