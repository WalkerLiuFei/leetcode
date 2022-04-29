package personal.walker.dp.linear;

import personal.walker.Solution;

public class LC198 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(rob(new int[]{9,9,2,3,4,5,6}));
        System.out.println(rob(new int[]{9,9,2,3,9}));
        System.out.println(rob(new int[]{9,9,2,3,9,21}));
        System.out.println(rob(new int[]{9,9,2,3,2,3}));
    }
    /**
     * rob nums[i] :
     * 状态转移方程 ： dp[i] = MAX(MAX(dp[i-2] + nums[i],dp[i-3] + nums[i]))
     * not rob nums[i] :
     *
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        if (nums.length > 0){
            dp[0] = nums[0];
        }
        if (nums.length > 1){
            dp[1] = Math.max(nums[0],nums[1]);
        }
        if (nums.length > 2){
            dp[2] = Math.max(dp[0]+nums[2],dp[1]);
        }
        for (int i = 3; i < nums.length;i++){
            dp[i] = Math.max(Math.max(dp[i-2] + nums[i],dp[i-3] + nums[i]),dp[i-1]);
        }
        return dp[nums.length -1];
    }
}
