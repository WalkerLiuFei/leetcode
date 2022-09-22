package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashSet;

public class LC6171 implements Solution {
    @Override
    public void runTestCases() {

    }

    public boolean findSubarrays(int[] nums) {
        int size = 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++){
            int temp = nums[i] + nums[i - 1];
            if (set.contains(temp)){
                return true;
            }
            set.add(temp);
        }
        return false;
    }

}
