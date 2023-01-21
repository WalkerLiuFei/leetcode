package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC6237 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int distinctAverages(int[] nums) {
        Set<Double> doubleHashSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1;  i < j ; i++,j--){
            doubleHashSet.add((nums[i] + nums[j]) / 2.0);
        }
        return doubleHashSet.size();
    }
}
