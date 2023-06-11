package personal.walker.sliding.window;

import personal.walker.Solution;

import java.util.*;

public class LC6390 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(Arrays.toString(getSubarrayBeauty(new int[]{-3,1,2,-3,0,-3},2,1)));
    }
    public static class NegativeNumber {
        int value;
        int index;

        public NegativeNumber(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        TreeSet<NegativeNumber> windowNegatives = new TreeSet<>(Comparator
                .comparingInt((NegativeNumber neg) -> neg.value)
                .thenComparingInt(neg -> neg.index));

        for (int i = 0; i < n; i++) {
            // If the current number is negative, add it to the TreeSet
            if (nums[i] < 0) {
                windowNegatives.add(new NegativeNumber(nums[i], i));
            }

            // Remove the leftmost element if the window size exceeds k
            if (i >= k && nums[i - k] < 0) {
                windowNegatives.remove(new NegativeNumber(nums[i - k], i - k));
            }

            // Calculate the beauty of the current subarray
            if (i >= k - 1) {
                int beauty = 0;
                if (x <= windowNegatives.size()) {
                    int count = 1;
                    for (NegativeNumber value : windowNegatives) {
                        if (count == x) {
                            beauty = value.value;
                            break;
                        }
                        count++;
                    }
                }
                result[i - k + 1] = beauty;
            }
        }

        return result;
    }

}
