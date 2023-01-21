package personal.walker.dp;

import personal.walker.Solution;

public class LC1143 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(longestCommonSubsequence("abcc","acde"));
    }

    /**
     *
     * abcd
     * aabc
     *
     * @param text1
     * @param text2
     * @return
     */

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[i+1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i+1][j + 1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
