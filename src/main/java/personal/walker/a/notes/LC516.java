package personal.walker.a.notes;

import personal.walker.Solution;

/**
 * 最长回文子序列
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class LC516 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * 记录最近一次
     * dp[i] = max(dp[i-1],)
     * dp[i][j] = dp[0][1] = 0
     *
     * if s[i] == s[j] then  dp[i][j] = dp[i+1][j-1] + 2
     * else s[i] != [sj] then dp[i][j] = max(dp[i][j-1],dp[i+1][j])
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        return 0;
    }
}
