package personal.walker.dp.knapsack;

import personal.walker.Solution;

import java.util.Map;

public class LC474 implements Solution {
    @Override
    public void runTestCases() {
        findMaxForm(new String[]{"10","0001","111001","1","0"},5,3);
    }

    /**
     * 最大子集，take or not take it, 是典型的01背包问题。
     * dp[i][j] = max(dp[i-1][j][k],dp[i][j-zeroCount][k-oneCount] + 1)
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[] zeroCountArray = new int[strs.length];
        int[] oneCountArray = new int[strs.length];
        for (int i = 0; i < strs.length;i++){
            int zeroCount = 0;
            int oneCount = 0;
            for (byte b : strs[i].getBytes()){
                if (b == '1'){
                    oneCount++;
                }else {
                    zeroCount++;
                }
            }
            zeroCountArray[i] = zeroCount;
            oneCountArray[i] = oneCount;
        }
        /**
         * 最多零时的求出一个最大序列，最多1时求出一个最大序列，他们中比较小的那个就是最终结果
         */
        int[][] dp = new int[m+1][n+1];
        //dp[0][0] = 1;
        for (int i = 0; i < strs.length;i++){
            for (int mCount = m;mCount >= zeroCountArray[i]; mCount--)
            for (int nCount = n;nCount >= oneCountArray[i]; nCount--){{
                    dp[mCount][nCount] = Math.max(dp[mCount][nCount],dp[mCount-zeroCountArray[i]][nCount-oneCountArray[i]] + 1);
                    System.out.printf("max sub array is %d,m : %d n : %d, when scan to index %d \n",dp[mCount][nCount],mCount,nCount,i);
                }
            }
        }
        return dp[m][n];
    }
}
