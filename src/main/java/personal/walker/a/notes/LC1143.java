package personal.walker.a.notes;

import personal.walker.Solution;

public class LC1143 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * dp[i][j] =
     *      1. s1[i] == s[j] : dp[i+1][j+1]
     *      2. s1[i] != s[j] : max(dp[i-1][j],dp[i][j-1])
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }



}
