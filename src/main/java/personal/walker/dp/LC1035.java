package personal.walker.dp;

import personal.walker.Solution;

public class LC1035 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(maxUncrossedLines(new int[]{2,5,1,2,5},new int[]{10,5,2,1,5,2}));
    }

    /**
     * longest common sequence 同样的问题
     * dp[i][j] :
     *        1. n1[i] == n2[j] : max( dp[i-1][j-1] + 1,dp[i-1][j],dp[i][j-1])
     *        2. n1[i] != n2[j] : max(dp[i-1][j],dp[i][j-1])
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        dp[0][0] = 0;
        for (int i = 0; i < nums1.length;i++){
            for (int j = 0; j < nums2.length; j++){
                if (nums1[i] == nums2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1],dp[i + 1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
