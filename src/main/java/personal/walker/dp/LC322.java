package personal.walker.dp;

import personal.walker.Solution;

import java.util.Arrays;

public class LC322 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{ 2}, 3));
        System.out.println(coinChange(new int[]{ 2}, 0));
        System.out.println(coinChange(new int[]{ 2}, 1));

    }

    /**
     * dp[amount] = Math.Min(dp[amount-coin] + 1)
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
       // Arrays.fill(dp, Integer.MAX_VALUE >> 1);
//        for (int coin : coins) {
//            dp[coin] = 1;
//        }
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                //System.out.printf("amount i %d min step %d \n", i, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE >> 1 ? -1:dp[amount];
    }
}
