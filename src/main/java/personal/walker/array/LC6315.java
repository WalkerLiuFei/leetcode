package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC6315 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        Set set = new HashSet(Arrays.asList('a','e','i','o','u' ));

        for (int i = left; i <= right;i++){
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))){
                result++;
            }
        }
        return result;
    }
}
