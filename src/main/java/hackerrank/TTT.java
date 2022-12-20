package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
//https://stackoverflow.com/questions/5963983/find-the-minimum-number-of-elements-required-so-that-their-sum-equals-or-exceeds
public class TTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// output: 1
		System.out.println(minElementsForSum(3, List.of(1, 1, 2, 4)));
		// sample case in question
		// output: 3
		//System.out.println(minElementsForSum(5, List.of(2, 2, 2, 2, 4)));
		
		//System.out.println(minElementsForSum(10, List.of(1, 1, 2, 4, 4)));
		//System.out.println(minElementsForSum(8, List.of(1, 1, 2, 2, 4)));


		// sample case 0
		// output: 4
		//System.out.println(minElementsForSum(4, List.of(1, 1, 1)));

		// sample case 1
	}
	static int minElementsForSum(int load, List<Integer> list){
		Queue<Integer> queue = new PriorityQueue<Integer>(list.size());
		//list.forEach(queue::add);
		int[] elems =Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().mapToInt(i -> i).toArray();

	
		//Walk through elements, until the sum of the first few exceeds S.
		int sum = 0;
		int i =0;
		 for(int elem : elems) {
			 if (queue.peek() < elem) {
				 queue.offer(elem);
				 sum += elem;
				 while (load + queue.peek() < sum) {
					 sum -= queue.peek();
					 queue.poll();
				 }
			 }
			 i++;
		 }
		
		 return queue.size();

	}
}
