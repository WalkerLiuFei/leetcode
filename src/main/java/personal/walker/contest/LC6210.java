package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC6210 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int max = -1;
        for (int num : nums){
            if (num > max && set.contains(-num) ){
                max = num;
            }
        }
        return max;
    }

}
