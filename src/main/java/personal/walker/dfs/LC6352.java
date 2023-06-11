package personal.walker.dfs;

import personal.walker.Solution;

import java.util.*;

public class LC6352 implements Solution {
    @Override
    public void runTestCases() {
        // 23
        //System.out.println((beautifulSubsets(new int[]{4,2,5,9,10,3},1)));
        // 23
        System.out.println((beautifulSubsets(new int[]{10, 4, 5, 7, 2, 1}, 3)));

        // System.out.println((beautifulSubsets(new int[]{1},1)));

    }

//
//    public int beautifulSubsets(int[] nums, int k) {
//    }

//
//    public int countBeautifulSubsets(int[] nums, int k) {
//        return countBeautifulSubsetsHelper(nums, k, 0, new ArrayList<>());
//    }
//
//    private int countBeautifulSubsetsHelper(int[] nums, int k, int index, List<Integer> subset) {
//        if (index == nums.length) {
//            // Base case: check if subset is beautiful
//            if (subset.size() < 1) {
//                return 0;
//            }
//            for (int i = 0; i < subset.size(); i++) {
//                for (int j = i + 1; j < subset.size(); j++) {
//                    if (Math.abs(subset.get(i) - subset.get(j)) == k) {
//                        return 0;
//                    }
//                }
//            }
//            return 1;
//        } else {
//            // Recursive case: either include nums[index] or not
//            return countBeautifulSubsetsHelper(nums, k, index + 1, subset) +
//                    countBeautifulSubsetsHelper(nums, k, index + 1, new ArrayList<Integer>(subset) {{add(nums[index]);}});
//        }
//    }
//
//

    public int beautifulSubsets(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int[] mapper = new int[2001];
            mapper[nums[i]] = 1;
            recursive(nums, i, mapper, k);
        }
        return result;
    }

    int result = 0;

    public void recursive(int[] nums, int currentIndex, int[] mapper, int target) {
        if ((nums[currentIndex] >= target && mapper[nums[currentIndex] - target] > 0)
                || (mapper[nums[currentIndex] + target] > 0)) {
            return;
        }
        result++;
        print(mapper);
        for (int i = currentIndex + 1; i < nums.length; i++) {
            mapper[nums[i]]++;
            recursive(nums, i, mapper, target);
            mapper[nums[i]]--;
        }
    }

    private void print(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {

            if (result[i] > 0) {
                sb.append(",");
                sb.append(i);
            }
        }
        System.out.println(sb.toString());
    }
}
