package personal.walker;

import personal.walker.bit.operation.LC476;
import personal.walker.dfs.LC1192;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Sum_4 sum_4 = new Sum_4();
//        int[] nums = new int[]{43,12};
//        sum_4.sort(nums,0,nums.length);
//        Arrays.stream(nums).forEach(System.out::println);
//        LC179 largestNumber = new LC179();
//        largestNumber.runTestCases();
//
       // System.out.println(Integer.parseInt("09",10));;

        Solution lc = new LC1192();
        lc.runTestCases();
     }


    /**
     * Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
     *
     * Return an array of all the words third for each occurrence of "first second third".
     * @param text
     * @param first
     * @param second
     * @return
     */

    public String[] findOcurrences(String text, String first, String second) {
        String[] parts =  text.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < parts.length - 2;i++ ){
            if (parts[i].equals(first) && parts[i+1].equals(second)){
                result.add(parts[i+3]);
            }
        }
        return result.toArray(new String[]{});
    }

    /**
     * Given a binary string s and a positive integer n, return true if the binary representation of all the integers in the range [1, n] are substrings of s, or false otherwise.
     *
     * A substring is a contiguous sequence of characters within a string.
     *
     *
     * @param s
     * @param n
     * @return
     */

}



