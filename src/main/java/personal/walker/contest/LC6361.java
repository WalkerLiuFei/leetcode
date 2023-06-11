package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6361 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(minimizeSum(new int[]{31, 25, 72, 79, 74, 65}));
        System.out.println(minimizeSum(new int[]{59,27,9,81,33}));

    }


    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return Math.min(Math.min(nums[nums.length - 2] - nums[1],nums[nums.length -1]  - nums[2]),nums[nums.length - 3] - nums[0]);
    }

}
