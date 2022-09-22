package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6132 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int minimumOperations(int[] nums) {


        int result = 0;

        while (true){
            int smallest = 1 << 31 - 1;
            for (int i =0; i < nums.length ; i++) {
                if (nums[i] <= 0){
                    continue;
                }
                if (nums[i] < smallest){
                    smallest = nums[i];
                }
            }
            boolean flag = true;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] > 0) {
                    flag = false;
                    nums[i] -= smallest;
                }
            }
            if (flag) {
                break;
            }
            result++;
        }
        return result;
    }
}
