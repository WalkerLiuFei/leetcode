package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC6142 implements Solution {
    @Override
    public void runTestCases() {

    }


    public long countBadPairsA(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] != j - i) {
                    result++;
                }
            }
        }
        return result;
    }
}

