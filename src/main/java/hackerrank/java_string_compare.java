package hackerrank;

public class java_string_compare {
	/*
	 * Sample Input 
	 * 
	 * welcometojava 3 
	 * 
	 * Sample Output 0
	 * 
	 * ava wel 
	 */
	public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        for(int i = 0 ; i+k-1< s.length(); i++){
            if(s.substring(i, i+k).compareTo(smallest)<0){
                smallest = s.substring(i, i+k);
            }else if(s.substring(i, i+k).compareTo(largest)>0){
                largest = s.substring(i, i+k);
            }
        } 
        return smallest + "\n" + largest;
    }
}
