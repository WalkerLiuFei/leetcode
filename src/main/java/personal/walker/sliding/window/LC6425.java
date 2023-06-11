package personal.walker.sliding.window;

import personal.walker.Solution;

public class LC6425 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(longestSemiRepetitiveSubstring("11223"));
    }


    public int longestSemiRepetitiveSubstring(String s) {
        int i = 0, j = 1;
        int result = Math.min(s.length(), 2);
        while (j < s.length()) {
            boolean flag = false;
            int firstRepeat = 0;
            while (j  < s.length() && (!flag || s.charAt(j) != s.charAt(j - 1))) {
                if (!flag && s.charAt(j) == s.charAt(j - 1)){
                    firstRepeat = j;
                }
                flag = s.charAt(j) == s.charAt(j - 1) || flag;
                j++;
            }
            result = Math.max(result, j - i);
            i = firstRepeat;
        }
        return result;
    }
}
