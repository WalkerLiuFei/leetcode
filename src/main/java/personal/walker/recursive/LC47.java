package personal.walker.recursive;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC47 implements Solution {
    @Override
    public void runTestCases() {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(nums,new HashSet<>(),new ArrayList<>(),result);
        return result;
    }

    public void recursive(int[] nums, Set<Integer> usedIndex, List<Integer> list, List<List<Integer>> result){
        if (nums.length == usedIndex.size()){
            return;
        }
        // 判断nums 中的是否已经被
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length;i++){
            int num = nums[i];
            if (set.contains(num) || usedIndex.contains(i)){
                continue;
            }
            set.add(num);
            list.add(num);
            usedIndex.add(i);
            recursive(nums,usedIndex,list, result);
            if (list.size() == nums.length){
                result.add(new ArrayList<>(list));
            }
            usedIndex.remove(i);
            list.remove(list.size() - 1);
        }
    }
}
