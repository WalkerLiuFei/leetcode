package personal.walker.string;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LC6462 implements Solution {
    @Override
    public void runTestCases() {

    }


    public static int minimizedStringLength(String s) {
        HashSet<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }

        return set.size();
    }



}
