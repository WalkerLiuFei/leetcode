package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;

public class LC1679 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        for (int i =0 , j = nums.length - 1; i < j;){
            int sum = nums[i] + nums[j];
            if (sum > k){
                j--;
            }else if (sum < k){
                i++;
            }else {
                i++;
                j--;
                result++;
            }
        }

        return result;
    }

}
