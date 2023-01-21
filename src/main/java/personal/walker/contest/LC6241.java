package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC6241 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int unequalTriplets(int[] nums) {
        int result = 0;
         for (int i = 0; i < nums.length; i ++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] != nums[j]){
                    for (int k = j + 1; k< nums.length; k++){
                        if (nums[k] != nums[i] && nums[k] != nums[j]){
                            result++;
                        }
                    }
                }

            }
         }
        return result;
    }

}
