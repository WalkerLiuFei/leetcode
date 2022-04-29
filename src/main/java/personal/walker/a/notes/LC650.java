package personal.walker.a.notes;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC650 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(minSteps(100));
        System.out.println(minSteps(18));
        System.out.println(minSteps(15));
        System.out.println(minSteps(361));
        System.out.println(minSteps(735));
    }

    /**
     * 这是个数学问题，最终求解其实就是判断
     * 2,3,5,7,11,13,17....
     * 首先利用素数快速筛选法，筛选出n以内的全部素数，这些素数的个数肯定就是 n。
     * 然后 n / 其中最大的素数，如果可以整除，除数 + 结果就是最终结果
     *
     *
     *
     *
     * 正确答案 ：
     *     int[] dp = new int[n+1];
     *
     *         for (int i = 2; i <= n; i++) {
     *             dp[i] = i;
     *             for (int j = i-1; j > 1; j--) {
     *                 if (i % j == 0) {
     *                     dp[i] = dp[j] + (i/j);
     *                     break;
     *                 }
     *
     *             }
     *         }
     *         return dp[n];
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        boolean[] colored = new boolean[n + 1];
        //Arrays.fill(multiplier, Integer.MAX_VALUE);
        for (int i = 2; i <= n; i++) {
            // i 不是素数
            if (colored[i]) {
                continue;
            }
            for (int count = 2; i * count <= n; count++) {
                colored[i * count] = true;
            }
        }
        if (!colored[n]){
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (!colored[i]) {
                dp[i] = i;
            }
        }
        return 0;
    }
}
