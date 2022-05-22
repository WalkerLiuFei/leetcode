package personal.walker.math;

import com.google.gson.Gson;
import personal.walker.Solution;

public class LC1641 implements Solution {
    @Override
    public void runTestCases() {
        for (int c = 0; c < 35; c++){
            System.out.println(countVowelStrings(c));
        }
    }

    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 5;
        }
        dp[2] = new int[]{1,2,3,4,5};
        for (int i = 3; i <= n; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i][0] + dp[i-1][1];
            dp[i][2] = dp[i][1] + dp[i-1][2];
            dp[i][3] = dp[i][2] + dp[i-1][3];
            dp[i][4] = dp[i][3] + dp[i-1][4];
        }
        int result = 0;
        for(int i = 0; i < 5;i++){
            result += dp[n][i];
        }
        return result;
    }
}
