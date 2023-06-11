package personal.walker.dp;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6449 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(minCost(new int[]{20, 1, 15}, 5));
    }

    /**
     * DP[i] =
     */
    public long minCost(int[] nums, int x) {
        //怎么决定是否收割 ? 在走过的路上选择价格最低的index作为收割即可！
        int[][] minPrefix = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(minPrefix[i], 1 << 30);
            minPrefix[i][0] = nums[i];
            for (int step = 1; step < nums.length; step++) {
                minPrefix[i][step] = Math.min(nums[(i + step) % nums.length],minPrefix[i][step - 1]);
            }
        }
        long result = Long.MAX_VALUE;
        for (int count = 0; count < nums.length; count++) {
            long current = (long) count * x;
            for (int i = 0; i < nums.length; i++) {
                current += minPrefix[i][count];
            }
            result = Math.min(current, result);
        }
        return result;
    }
}