package personal.walker.sliding.window;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1695 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));

    }

    public int maximumUniqueSubarray(int[] nums) {
        int start = 0, end = 0, windowVal = nums[0], result = nums[0];
        int[] v2Index = new int[10001];
        Arrays.fill(v2Index, -1);
        v2Index[nums[0]] = 0;

        while (++end < nums.length) {
            if (v2Index[nums[end]] != -1) {
                while (start <= v2Index[nums[end]]) {
                    windowVal -= nums[start++];
                }
            }
            v2Index[nums[end]] = end;
            result = Math.max(windowVal += nums[end], result);
        }
        return result;
    }
}
