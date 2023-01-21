package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6248 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int countSubarrays(int[] nums, int k) {
        int position = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == k){
                position = i;
                break;
            }
        }

        return 0;
    }

}
