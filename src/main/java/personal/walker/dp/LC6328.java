package personal.walker.dp;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6328 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(maximumCostSubstring("talaqlt",
                "tqla",
                new int[]{4, 3, 3, -2}));
    }


    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] charValues = new int[26];
        for (int i = 0; i < 26; i++) {
            charValues[i] = i + 1;
        }
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            charValues[c - 'a'] = vals[i];
        }
        int max = 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = charValues[s.charAt(0) - 'a'];
        if (dp[0] > max){
            max = dp[0];
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            dp[i] = Math.max(dp[i - 1] + charValues[c - 'a'], charValues[c - 'a']);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

}
