package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC6276 implements Solution {
    @Override
    public void runTestCases() {

    }


    static int CONST_NUM = 1000000007;
    public int countAnagrams(String s) {
        String[] parts = s.split(" ");
        int result = 1;
        for (String part : parts){
            result *= numAnagrams(part) % CONST_NUM;
            result %= CONST_NUM;
        }
        return result;
    }

    public  int numAnagrams(String s) {
        // Calculate the frequency of each character in the string
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        // Calculate the number of anagrams
        int numAnagrams = factorial(s.length());
        for (int count : freq.values()) {
            numAnagrams /= factorial(count);
        }
        return numAnagrams;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
