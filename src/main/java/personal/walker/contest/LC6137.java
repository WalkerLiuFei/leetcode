package personal.walker.contest;

import personal.walker.Solution;

public class LC6137 implements Solution {
    @Override
    public void runTestCases() {
        validPartition(new int[]{4,4,4,5,6});
    }

    /**
     * dp[i] = dp[i - 2] if num[i-1] == num[i]
     * = dp[i - 3] if num[i-1] == num[i] == nums[i-2] || dp[i] - dp[i-1] = 1 && dp[i - 1] d
     * <p>
     * dp[0] = true
     */


    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        dp[1] = false;
        for (int i = 2; i < dp.length; i++) {
            boolean flag1 =  nums[i - 1] == nums[i - 2] && dp[i-2];
            boolean flag2 =  i > 2 && nums[i - 1] == nums[i - 2] && nums[i - 1] == nums[i-3] && dp[i-3];
            boolean flag3 =  i > 2 && nums[i - 1] - nums[i - 2]  == 1 && nums[i - 1] - nums[i-3] == 2 && dp[i-3];
            dp[i] = flag1 || flag2 || flag3;
        }
        return dp[nums.length];
    }
}
