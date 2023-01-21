package personal.walker.contest;

import personal.walker.Solution;

public class LC6229 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int[] applyOperations(int[] nums) {
        for (int i = 0 ; i < nums.length - 1; i ++){
            if (nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int[] result = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0){
                continue;
            }
            result[j] = nums[i];
            j++;
        }
        return result;
    }

}
