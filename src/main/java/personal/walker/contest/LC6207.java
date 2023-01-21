package personal.walker.contest;

import personal.walker.Solution;

public class LC6207 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5, 1, 1, 1}, 1, 5));
        System.out.println(countSubarrays(new int[]{1, 3, 5, 5, 3, 5, 1, 5, 1}, 1, 5));
        System.out.println(countSubarrays(new int[]{1, 1, 1, 1, 1}, 1, 1));

        System.out.println(countSubarrays(new int[]{1, 1, 3, 5, 5}, 1, 5));


        System.out.println(countSubarrays(new int[]{1, 5, 1}, 1, 5));
        // 81
        System.out.println(countSubarrays(
                new int[]{35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913}, 35054, 945315));
    }

    /**
     *
     */
    public long cornCase(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0] == k ? 1 : 0;
        int count = nums[0] == k ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == k) {
                count++;
            }
            if (nums[i] == k) {
                dp[i] = dp[i - 1] + count;
            } else {
                count = 0;
            }
        }
        return dp[nums.length - 1];
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        if (minK == maxK) {
            return cornCase(nums, minK);
        }

        int lastSatisfyIndex = 0;
        int lastMinIndex = -1;
        int lastMaxIndex = -1;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!(nums[i] >= minK && nums[i] <= maxK)) {
                lastSatisfyIndex += 1;
                lastMinIndex = -1;
                lastMaxIndex = -1;
            }
            if (nums[i] == minK) {
                lastMinIndex = i;
                if (lastMaxIndex != -1 ) {
                    result += Math.max(0,lastMaxIndex - lastSatisfyIndex + 1);
                }
            }
            if (nums[i] == maxK) {
                lastMaxIndex = i;
                if (lastMinIndex != -1) {
                    result += Math.max(0,lastMinIndex - lastSatisfyIndex + 1);
                }
            }
            if (nums[i] > minK && nums[i] < maxK && Math.min(lastMinIndex, lastMaxIndex) >= 0) {
                result += 1;
            }

        }
        return result;
    }

}
