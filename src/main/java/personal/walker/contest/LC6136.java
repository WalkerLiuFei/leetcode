package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6136 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int arithmeticTriplets(int[] nums, int diff) {
        Arrays.sort(nums);
        int result = 0;
        for (int j = 0; j < nums.length;j++){
            boolean flag1 = false;
            for (int i = j - 1;  i >= 0;i--){
                flag1 = nums[j] - nums[i] == diff;
                if (flag1){
                    break;
                }
            }
            if (flag1){
                boolean flag2 = false;
                for (int k =  j +1 ; k < nums.length;k++){
                    flag2 = nums[k] - nums[k] == diff;
                    if (flag2){
                        break;
                    }
                }
                if (flag2){
                    result++;
                }
            }
        }
        return result;
    }
}
