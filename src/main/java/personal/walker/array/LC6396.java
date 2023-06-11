package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6396 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(
                count("1","12",1,8)
        );
    }


    final int MOD = 1000000007;

    private int[][][] dp = new int[21][2][200];

    public int count(String num1, String num2, int max_sum, int min_sum) {
        int[] num = getNum(num2);
        int total1 = dp(num, max_sum);
        num = getNum(num1);
        int total2 = dp(num, max_sum);
        return (total1 - total2 + MOD) % MOD;
    }

    private int[] getNum(String num) {
        while (num.length() < 20) num = "0" + num;
        int[] res = new int[20];
        for (int i = 0; i < 20; i++) {
            res[i] = num.charAt(i) - '0';
        }
        return res;
    }

    private int dp(int[] num, int max_sum) {
        for (int[][] arr2d : dp) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }
        return dfs(num, 0, 0, 0, max_sum, true);
    }

    private int dfs(int[] num, int idx, int sum, int state, int max_sum, boolean lead) {
        if (sum > max_sum) return 0;
        if (idx == num.length) return 1;
        if (!lead && dp[idx][state][sum] != -1) return dp[idx][state][sum];

        int up = state > 0 ? num[idx] : 9;
        int res = 0;
        for (int i = 0; i <= up; i++) {
            if (i == 0 && lead) {
                res += dfs(num, idx + 1, 0, state, max_sum, true);
            } else {
                res += dfs(num, idx + 1, sum + i, state == 1 && i == up ? 1 : 0, max_sum, false);
            }
            res %= MOD;
        }
        if (!lead) dp[idx][state][sum] = res;
        return res;
    }


}
