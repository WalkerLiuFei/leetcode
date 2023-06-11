package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6355 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(countFairPairs(new int[]{0,1,7,4,4,5},3,6));
        System.out.println(countFairPairs(new int[]{0,0,0,0,0,0},0,0));

    }

    // 0,1,4,4,5,7
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int j = binarySearch(nums, i + 1, n, upper - nums[i]);
            int k = binarySearch(nums, i + 1, n, lower - nums[i] - 1);
            res += j - k;
        }
        return res;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
