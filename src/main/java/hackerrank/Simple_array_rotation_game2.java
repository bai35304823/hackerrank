package hackerrank;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/forum
public class Simple_array_rotation_game2 {
// For left it will be int newLoc= (n +(i-k))%n;
// new_index = (i + no_of_left_rotation) % length_of_array
	
	static int [] rotate(int [] arr, int k) {
		for(int i = 0; i < arr.length; i++){
		    int newLocation = (i +  k) % arr.length;   
		    System.out.println(arr[newLocation]); 
		}
		return arr;
	}
	
	static void swap(int charArray[], int i, int j) {
        int temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
	 
	public static void main(String[] args) {
		rotate(new int [] {1,2,3,4,5}, 4);
	}
}
