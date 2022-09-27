package personal.walker;

import personal.walker.a.notes.LC1680;
import personal.walker.a.notes.LC287;
import personal.walker.array.LC838;
import personal.walker.contest.LC6189;
import personal.walker.contest.LC6190;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution lc = new LC838();
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



