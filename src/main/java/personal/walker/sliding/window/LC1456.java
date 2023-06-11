package personal.walker.sliding.window;

import personal.walker.Main;
import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1456 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int maxVowels(String s, int k) {
        int max = 0;
        int windowStart = 0;
        int windowEnd = 0;
        while (windowEnd < k) {
            char c = s.charAt(windowEnd);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                max++;
            }
            windowEnd++;
        }
        int current = max;
        while (windowEnd < s.length()){
            char c = s.charAt(windowStart);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                current--;
            }
            c = s.charAt(windowEnd);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                current++;
            }
            max = Math.max(current,max);
            windowStart++;
            windowEnd++;
        }
        return max;
    }
}

