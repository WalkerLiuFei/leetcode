package personal.walker.contest;

import personal.walker.Solution;

public class LC6067 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(waysToSplitArray(new int[]{10, 4, -8, 7}));

        System.out.println(waysToSplitArray(new int[]{2, 3, 1, 0}));

        System.out.println(waysToSplitArray(new int[]{0}));

        System.out.println(waysToSplitArray(new int[]{0, 0, 0, 0, 9}));
        System.out.println(waysToSplitArray(new int[]{9,1,1,1,1}));
        System.out.println(waysToSplitArray(new int[]{1,1,1,1,1}));
        System.out.println(waysToSplitArray(new int[]{1}));
        System.out.println(waysToSplitArray(new int[]{1}));


    }

    public int waysToSplitArray(int[] nums) {
        long[] rightSum = new long[nums.length];
        long[] leftSum = new long[nums.length];

        leftSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (leftSum[i] >= rightSum[i]) {
                ans++;
            }
        }
        return ans;
    }
}
