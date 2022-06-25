package personal.walker.array;

import personal.walker.Solution;

public class LC665 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     *
     * 1. 首先要判断修改哪一个数
     * 2.
     * @param nums
     * @return
     */

    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        for (int index = 1 ; index < nums.length; index++){
            if (nums[index - 1] > nums[index] ){
                if (flag){
                    return false;
                }
                if (index == nums.length - 1){
                    return true;
                }
                if (nums[index - 1] > nums[index + 1]){
                    return false;
                }else {

                }
                flag = true;
            }
        }
        return true;
    }

}
