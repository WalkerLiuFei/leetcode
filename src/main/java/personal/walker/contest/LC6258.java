package personal.walker.contest;

import personal.walker.Main;
import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC6258 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[100001];
        int result = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i ++){
            dp[nums[i]] = 1;
        }
        for (int i = 0; i < nums.length;i ++){
            double doubleNum = Math.sqrt(nums[i]);
            if (Math.floor(doubleNum) == doubleNum){
                dp[nums[i]] = dp[(int)doubleNum] + 1;
            }
            result = Math.max(dp[nums[i]],result);
        }
        return result == 1 ? -1 : result;
    }
}
