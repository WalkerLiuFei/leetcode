package personal.walker.dp.knapsack;

import personal.walker.Solution;

public class LC213 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        if (nums.length == 3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(dp[0] + nums[2], dp[1]);

        for (int i = 3; i < nums.length-1; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]), dp[i - 1]);
        }
        int save = dp[nums.length-2];
        nums[0] = 0;
        dp[0] = 0;
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(dp[0] + nums[2], dp[1]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]), dp[i - 1]);
        }

        return Math.max(save,dp[nums.length - 1]);
    }

}
