package personal.walker.dp;

import personal.walker.Solution;

public class LC1749 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(maxAbsoluteSum(new int[]{-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9}));
//        System.out.println(maxAbsoluteSum(new int[]{-7,1,3,8}));
//        System.out.println(maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
        System.out.println(maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }

    /**
     * dp[i] = dp[i-1]
     *  1,-3,2,3,-4
     *  1,2,0,3,1
     *  1,2,1,1,4
     *  dp[i][j] =
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
         int sum = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i ++){
            if (Math.abs(sum + nums[i]) < Math.abs(sum) || Math.abs(nums[i]) > Math.abs(sum + nums[i])){
                sum = nums[i];
            }else {
                sum = sum + nums[i];
            }
            if (Math.abs(sum) > Math.abs(result)){
                result = sum;
            }
            System.out.printf("%d -> %s \n",i,Math.abs(result));
         }
        return Math.abs(result);
    }

}
