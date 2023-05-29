package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;

public class test_monotonous_stack {

public static void main(String[] args) {
	int array[] = { 5, 4, 5, 1, 3, 3, 8, 2 };
	System.out.println(finalPrice(array));
}


public static int finalPrice(int[] prices){
    if(prices.length==0) return 0;
    // Next Less Element
    Deque<Integer> NLE = new ArrayDeque<>();
    int res = 0;
    for(int i=prices.length-1;i>=0;i--){
        while (NLE.size()!=0&&NLE.peekFirst()>prices[i]){
            NLE.pollFirst();
        }

        res += NLE.isEmpty() ? prices[i] : prices[i] - NLE.peek();
        NLE.offerFirst(prices[i]);
    }
    return res;
}
}