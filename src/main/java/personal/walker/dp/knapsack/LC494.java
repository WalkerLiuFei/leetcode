package personal.walker.dp.knapsack;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC494 implements Solution {
    @Override
    public void runTestCases() {
        findTargetSumWays(new int[]{1,1,1,1,1,1},3);
    }

    /**
     * 01背包问题
     * 状态转移方程 ：
     * dp[i][target] = dp[i-1][target - nums[i]] + dp[i-1][target+nums[i]]
     * 因为二维的状态从 -sum(nums[i]) 到 sum(nums[i])都可能出现，但是数组不可能是负数下标，所以需要两个DP数组存储状态
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
       // Map<Integer,Integer> mapper = new HashMap<>();
        int sumOfAllNum = 0;
        for (int num : nums){
            sumOfAllNum+= num;
        }
         // 正数下标
        HashMap<Integer,Integer>[] dp = new HashMap[nums.length+1];
        for (int i = 0; i < dp.length;i++){
            dp[i] = new HashMap<>();
        }
        dp[0].put(0,1);
        for (int i = 1;i <= nums.length;i++){
            for (int j = -sumOfAllNum ; j <= sumOfAllNum;j++){
                dp[i].put(j,dp[i-1].getOrDefault(j-nums[i - 1],0) + dp[i-1].getOrDefault(j+nums[i - 1],0));
                System.out.printf("index %d,target %d,count %d  \n",i,j, dp[i].get(j));
            }
        }
        return dp[nums.length].getOrDefault(target,0);
    }
}
