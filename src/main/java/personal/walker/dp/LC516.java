package personal.walker.dp;

import personal.walker.Solution;

import java.util.Arrays;

public class LC516 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     *  bcabc
     * initial all dp fill with 1.
     * dp[i][j] = nums[i] == nums[j] = dp[i-1][j+1] + 2
     *            nums[i] == nums[j+1] = dp[i][j+1] + 1
     *            nums[i-1] == nums[j]  = dp[i-1][j] + 1
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length();i++){dp[i][i] = 1;}

        for (int i = 1; i < s.length();i++){
            for (int j = i-1; j >= 0 ;j--){
                dp[i][j] = dp[i-1][j+1];
                if (s.charAt(i) == s.charAt(j)){
                   dp[i][j] = dp[i-1][j+1] + 2;
                }
                dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i][j+1]),dp[i][j]);
            }
        }
        return dp[s.length()-1][0];
    }
}
