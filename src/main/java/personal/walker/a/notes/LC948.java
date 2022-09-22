package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.Arrays;

public class LC948 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     *
     * dp[i][power] = max(dp[i-1][power] + 1,dp[i][power - power[i]])
     * 1. play it up, cut power add soccer
     * 2. play it down, cut soccer add power
     * 3. ignore it.
     * dp[i][powerCap] =
     *        1. max : dp[i-1][powerCap], dp[i-1][powerCap - []]
     * @param tokens
     * @param power
     * @return
     */

    // 典型的背包问题

    // dp[i][power] = dp[i-1][power-power[i]] + 1
    //      a. if power > token[i]
    //         + 1
    public int bagOfTokensScore(int[] tokens, int power) {
        int[][] dp = new int[tokens.length][10000];
        int powerCap = power;
        Arrays.fill(dp[0],-1);
        for (int i = 0; i < tokens.length; i++){
            for (int j = tokens[i]; j < 10000; j++){
                // face it down(do not take it).
                dp[i][j] = Math.max(dp[i-1][j - tokens[j]],dp[i-1][j - tokens[i]] + 1);
            }
        }
        return 0;
    }

}
