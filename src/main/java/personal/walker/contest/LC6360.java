package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class LC6360 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int minImpossibleOR(int[] nums) {
        Arrays.sort(nums);
        int res = 1; // Initialize result
        int orResult = nums[0];
        // Traverse the array and increment 'res' if arr[i] is
        // smaller than or equal to 'res'.
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > res){
                return res;
            }
            res++;
            orResult |= nums[i];
            if (orResult > res){
                return res;
            }
        }
        return res;
    }
}
