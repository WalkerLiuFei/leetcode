package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class LC6316 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum <= 0) {
                break;
            }
            result++;
        }
        return result;
    }

}
