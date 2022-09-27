package personal.walker.contest;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LC6189 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(longestSubarray(new int[]{1,2,3,3,2,2}));
        System.out.println(longestSubarray(new int[]{1,3,3,3,2,3,3,3,3}));
        System.out.println(longestSubarray(new int[]{1,3,3,3,2,3,3,3,3,3}));
        System.out.println(longestSubarray(new int[]{96317,96317,96317,96317,96317,96317,96317,96317,96317,279979}));
    }

    public int longestSubarray(int[] nums) {

        // find the max
        int max = nums[0];
        int result = 1;
        int current = 1;
        for (int i = 1; i < nums.length;i++) {
            int num = nums[i];
            if (max < num) {
                max = num;
                result = 1;
                current = 1;
                continue;
            } else if (max == num) {
                result = Math.max(++current,result);
                continue;
            }
            current = 0;
        }
        return result;
    }
}
