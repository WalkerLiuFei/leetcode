package personal.walker.contest;

import personal.walker.Solution;

public class LC6181 implements Solution {
    @Override
    public void runTestCases() {
        //System.out.println(longestContinuousSubstring("ababcdabcde"));
        System.out.println(longestContinuousSubstring("abcdefabcdabcde"));
        System.out.println(longestContinuousSubstring("abcdefg"));
        System.out.println(longestContinuousSubstring("ab"));

    }

    public int longestContinuousSubstring(String s) {
        int result = 1;
        for (int i = 1, j = 1; j < s.length(); i++) {
            while (j < s.length() && s.charAt(j) == s.charAt(j - 1) + 1) {
                j++;
            }
            result = Math.max(j - i + 1,result);
            i = j;
            j++;
        }
        return result;
    }
}
