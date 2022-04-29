package personal.walker.string;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC830 implements Solution {
    @Override
    public void runTestCases() {

        List<List<Integer>> result = largeGroupPositions("abbxxxxzyy");

    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        if (s.length() < 3) {
            return result;
        }
        int i = 0, j = 1;
        while (j < s.length()) {
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if (j - i > 2) {
                result.add(Arrays.asList(i, j));
            }
            i = j;
            j++;
        }
        return result;
    }

}
