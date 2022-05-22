package personal.walker.dp;

import personal.walker.Solution;

import java.util.Arrays;

public class LC2262 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(appealSum("aebcef"));
        System.out.println(appealSum("eabcefe"));

    }

    /**
     * 一个二维数组，一维的信息是 index，二维是子数组长度 length
     * a : 1
     * ab : 1 + 1 + 2 = 3
     * abc : 1 + 1 + 2  + 1 + 2 + 3 = 10
     * abcd : 1 + 1 + 2 + 1 + 2 + 3 + 1 + 2 + 3 + 4 = 20
     * abcde :  1 + 1 + 2 + 1 + 2 + 3 + 1 + 2 + 3 + 4  + 1 + 2 + 3 + 4 + 5= 35
     * 有 ： dp[i] = dp[i - 1] + (n + 1) * n / 2
     * 再考虑如果有重复情况
     * abcee : 1 + 1 + 2 + 1 + 2 + 3 + 1 + 2 + 3 + 4  + 1 + (2-1) + (3-1) + (4 - 1) + (5 - 1)= 31
     * 因为 包含ee的的子数组都会受影响
     * aebce : 1 + 1 + 2 + 1 + 2 + 3 + 1 + 2 + 3 + 4  + 1 + (2) + (3) + (4 - 1) + (5 - 1)= 33
     * 同上，单这次是包含的 e**e的所有的子数组
     *
     * 总结规律：
     * last_i 为上次 s[i] 出现的index
     * dp[i] = dp[i] +  (n + 1) * n / 2 - (i -  (i - last_i)) = dp[i] +  (n + 1) * n / 2 - last_i
     *
     * 再在 aebce后面 增加 f : aebce
     * aebcef : f(aebce)  +  1 + 2 + 3 + 4 + (5 - 1) + (6 - 1) =  33 + 19 = 52
     * 再接一个f 则有 ：
     * aebceff :  f(aebcef) + 1 + (2 - 1) + (3 - 1) + (4 - 1) + (5 - 1) + (6 - 1 - 1) + (7 - 1 - 1)= 52 + (8 * 7) / 2 - 7 = 72
     * 有: dp[i] =  dp[i - 1] +  (n + 1) * n / 2 - SUM(repeat occurred indexes)
     *
     *
     *
     * @param s
     * @return
     */
    public long appealSum(String s) {
       // long[] dp = new long[s.length() + 1];
        long ans = 0;
        int[] repeatIndex = new int[28];
        Arrays.fill(repeatIndex, -1);
        long sumSubtract = 0;
        for (int i = 0; i < s.length(); i++) {
            if (repeatIndex[s.charAt(i) - 'a'] != -1){
                sumSubtract += repeatIndex[s.charAt(i) - 'a'];
            }
            long n = (long)i + 1;
            ans = ans + (((n + 1) * (n)) >> 1) - sumSubtract;
            repeatIndex[s.charAt(i) - 'a'] = i+1;
        }
        return ans;
    }
}
