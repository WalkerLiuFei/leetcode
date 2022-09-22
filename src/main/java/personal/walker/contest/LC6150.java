package personal.walker.contest;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class LC6150 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));
    }

    public String smallestNumber(String pattern) {
        boolean[] taken = new boolean[10];
        recursive(pattern, -1, taken, -1);
        StringBuilder resultStr = new StringBuilder();
        for (Integer num : result) {
            resultStr.append(num.toString());
        }
        return resultStr.toString();
    }

    List<Integer> result = new ArrayList<>();

    public boolean recursive(String pattern, int index, boolean[] token, int lastNum) {
        if (index >= pattern.length()) {
            return true;
        }
        for (int c = 1; c < 10; c++) {
            token[c] = true;
            if (index == -1 || (index >= 0 && pattern.charAt(index) == 'I' && !token[c] && c > lastNum)) {
                if (recursive(pattern, index + 1, token, c)) {
                    result.add(c);
                    return true;
                }
            }
            token[c] = false;
        }
        return true;
    }
}
