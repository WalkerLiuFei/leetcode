package personal.walker.dp;

import personal.walker.Solution;

import java.util.Arrays;

public class LC1155 implements Solution {
    @Override
    public void runTestCases() {

       // System.out.println(numRollsToTarget(4, 20, 24));
       // System.out.println(numRollsToTarget(30, 30, 500));
        System.out.println(numRollsToTarget(2, 12, 8));
    }
    /*
     * dp[i][j] = dp[i - 1][target - ALL{k}] + 1
     */
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];

        for (int i = Math.min(target,k); i > 0 ;i--){
            dp[1][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int k1 = 1; k1 <= k; k1++) {
                for (int j = 1; j <= target; j++) {
                    if (j - k1 < 0){
                        continue;
                    }
                    dp[i + 1][j] += dp[i][j - k1];
                    dp[i + 1][j] = dp[i + 1][j] % 1000000007;
                }
            }
        }
        return  dp[n][target];
    }

}
