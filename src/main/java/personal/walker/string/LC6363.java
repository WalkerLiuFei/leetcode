package personal.walker.string;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC6363 implements Solution {
    @Override
    public void runTestCases() {

    }



    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> usedIndex = new HashSet<>();
        while (usedIndex.size() < nums.length){
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length;i++) {
                if (usedIndex.contains(i)){
                    continue;
                }
                int num = nums[i];
                if (!set.contains(num)){
                    set.add(num);
                    usedIndex.add(i);
                }
            }
            result.add(new ArrayList<>(set));
        }
        return result;
    }

}
