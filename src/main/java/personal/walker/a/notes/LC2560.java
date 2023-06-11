package personal.walker.a.notes;

public class LC2560 {
     public void runTestCases() {
//        System.out.println(minCapability(new int[]{2, 3, 5, 9}, 2));
//        System.out.println(minCapability(new int[]{2, 7, 9, 3, 1}, 2));

        System.out.println(minCapability(new int[]{4, 22, 11, 14, 25}, 3)); //25
//
//        System.out.println(minCapability(new int[]{4,22,11,14,25,32,45}, 4)); //
//
//        System.out.println(minCapability(new int[]{9, 6, 20, 21, 8}, 3));
//
//        System.out.println(minCapability(new int[]{24, 1, 55, 46, 4, 61, 21, 52}, 3));

    }

    /**
     * 2,3,5,9
     * 贪心算法？ 往后找最小的数，替换前面的数字
     * 如果 k == 1， 只需要抢一个，nums.len == 2 时取max
     * k <= (nums.length + 1)/2、
     * <p>
     * 判断是否可以取nums[i] 还得看是否 之前有k-1个数满足小于 num[i-1]
     * dp[i] = nums[i] > dp[i-2] :   Math.min(dp[i - 2],dp[i - 3])
     *
     * @return
     */
    public int[] reverse(int[] nums) {

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        return nums;
    }

    public int minCapability(int[] nums, int k) {
        return Math.min(Math.min(helper(nums, k, 0), helper(reverse(nums), k, 0)), Math.min(helper(nums, k, 1), helper(reverse(nums), k, 1)));
    }

    public int helper(int[] nums, int k, int odd) {
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        if (k == 1) {
            int min = 1 << 31 - 1;
            for (int num : nums) {
                if (min > num) {
                    min = num;
                }
            }
            return min;
        }
        int dp[] = new int[nums.length];

        dp[(k - 1) * 2 - 1] = 1 << 31 - 1;

        for (int i = (k - 1) * 2; i < nums.length; i++) {

        }
        return Math.min(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
