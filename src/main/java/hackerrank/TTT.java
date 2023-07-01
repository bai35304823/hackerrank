package hackerrank;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.management.BadStringOperationException;
//https://stackoverflow.com/questions/5963983/find-the-minimum-number-of-elements-required-so-that-their-sum-equals-or-exceeds
public class TTT extends Writer{
	        float OSVersion;
	public static void main(String[] args) {
		TTT t = new TTT();
		int i1,i2;
		// i2 = i1  + 10;
		t.OSVersion = 10;
		// TODO Auto-generated method stub
		//static final int[] a = new int[2];
		// output: 1
		///System.out.println(minElementsForSum(3, List.of(1, 1, 2, 4)));
		// sample case in question
		// output: 3
		//System.out.println(minElementsForSum(5, List.of(2, 2, 2, 2, 4)));
		
		//System.out.println(minElementsForSum(10, List.of(1, 1, 2, 4, 4)));
		//System.out.println(minElementsForSum(8, List.of(1, 1, 2, 2, 4)));
//
//		File dir = new File("dir");
//		 dir.mkdir();
//		 File f1 = new File(dir, "f1.txt");
//	 try {
//		 f1.createNewFile();
//		 } catch (IOException e) { ; }
//		 File newDir = new File("newDir");
//		 dir.renameTo(newDir);
	
		//int x = 1;
		//int y =x;
		//int z = y;
		//z = 10;
      //  System.out.format("x,y,z: %d,%d,%d", x, y, z);
        List<Integer> sizes = new ArrayList<>();
        sizes.add(null);
        try {
		//	Object firstSize = sizes.get(0);
		} catch (Exception e) {
		//	throw new BadStringOperationException("");
		}
        LocalDate day = LocalDate.of(2015, Month.MAY, 27);
        day.plusDays(30);
        System.out.println(day);
	
		// sample case 0
		// output: 4
		//System.out.println(minElementsForSum(4, List.of(1, 1, 1)));

		// sample case 1
       // int[10] intArray; //line 1
        int xx = 5;
        System.out.println(--xx + 10);
        do {
        	
        }while (false);
        
        
        System.out.println("".charAt(0));
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
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	public void write() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
