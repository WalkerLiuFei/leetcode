package personal.walker.contest;

import personal.walker.Solution;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC6275 implements Solution {
    @Override
    public void runTestCases() {

    }


    public long minOperations(int[] nums1, int[] nums2, int k) {
         long count1 = 0;
        long count2 = 0;
        if (k == 0) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums2[i] != nums1[i]) {
                    return -1;
                }
            }
            return 0;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (Math.abs(nums2[i] - nums1[i]) % k != 0) {
                return -1;
            }
            if (nums2[i] > nums1[i]) {
                count2 += ((long) nums2[i] - (long) nums1[i]) / k;
            } else if (nums2[i] < nums1[i]) {
                count1 += ((long) nums1[i] - (long) nums2[i]) / k;
            }
        }
        if (count1 != count2) {
            return -1;
        }
        return count1;
    }
}
