package personal.walker.dp;

import personal.walker.Solution;

public class LC413 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**'
     *  1,2,3 = 2
     *  1,2,3,4 = 2 + 1 = 3
     *  1,2,3,4,5 = 3 + 2 + 1 = 6
     *  .......
     *
     *  if (4 - 3 == 1){
     *      t += 1
     *  }
     *
     *
     * @param nums
     * @return
     */

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int d = nums[0] - nums[1];
        int t = 0;
        for (int index = 2; index < nums.length;index++){
            if (nums[index - 1] - nums[index] == d){
                t++;
            }else {
                t = 0;
                d = nums[index - 1] - nums[index];
            }
            ans += t;
        }
        return ans;

    }

}
