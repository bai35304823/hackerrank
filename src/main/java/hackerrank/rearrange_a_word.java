package hackerrank;

import java.util.Arrays;
//https://stackoverflow.com/questions/1622532/algorithm-to-find-next-greater-permutation-of-a-given-string
public class rearrange_a_word {
//Algorithm to find next greater permutation of a given string
	
	/*
	 * Wikipedia has a nice article on lexicographical order generation. It also
	 * describes an algorithm to generate the next permutation.
	 * 
	 * Quoting:
	 * 
	 * The following algorithm generates the next permutation lexicographically
	 * after a given permutation. It changes the given permutation in-place.
	 * 
	 * Find the highest index i such that s[i] < s[i+1]. If no such index exists,
	 * the permutation is the last permutation. Find the highest index j > i such
	 * that s[j] > s[i]. Such a j must exist, since i+1 is such an index. Swap s[i]
	 * with s[j]. Reverse the order of all of the elements after index i till the
	 * last element.
	 */
	
	/**
     * method to find the next lexicographical greater string
     * 
     * @param w
     * @return a new string
     */
    static String rearrangeWord(String w) {
        char charArray[] = w.toCharArray();
        int n = charArray.length;
        int endIndex = 0;

        // step-1) Start from the right most character and find the first character
        // that is smaller than previous character.
        for (endIndex = n - 1; endIndex > 0; endIndex--) {
            if (charArray[endIndex] > charArray[endIndex - 1]) {
                break;
            }
        }

        // If no such char found, then all characters are in descending order
        // means there cannot be a greater string with same set of characters
        if (endIndex == 0) {
            return "no answer";
        } else {
            int firstSmallChar = charArray[endIndex - 1], nextSmallChar = endIndex;

            // step-2) Find the smallest character on right side of (endIndex - 1)'th
            // character that is greater than charArray[endIndex - 1]
            for (int startIndex = endIndex + 1; startIndex < n; startIndex++) {
                if (charArray[startIndex] > firstSmallChar && charArray[startIndex] < charArray[nextSmallChar]) {
                    nextSmallChar = startIndex;
                }
            }

            // step-3) Swap the above found next smallest character with charArray[endIndex - 1]
            swap(charArray, endIndex - 1, nextSmallChar);

            // step-4) Sort the charArray after (endIndex - 1)in ascending order
            Arrays.sort(charArray, endIndex , n);

        }
        return new String(charArray);
    }

    /**
     * method to swap ith character with jth character inside charArray
     * 
     * @param charArray
     * @param i
     * @param j
     */
    static void swap(char charArray[], int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
    
    public static void main(String[] args) {		
		// sample case in question
		// output: "bcaa"
		System.out.println(rearrangeWord("baca"));

		// sample case 0
		// output: "yx"
		System.out.println(rearrangeWord("xy"));

		// sample case 1
		// output: "no answer"
		System.out.println(rearrangeWord("pp"));
		
		// sample case 1
		// output: "hegf"
		System.out.println(rearrangeWord("hefg"));
	}
}
