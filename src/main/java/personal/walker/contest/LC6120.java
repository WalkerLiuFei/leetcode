package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC6120 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int[] numberOfPairs(int[] nums) {
        int[] result = new int[2];
        Set<Integer> removedIndex = new HashSet<>();
        HashMap<Integer,Integer> num2Index = new HashMap<>();
        for (int i = 0; i < nums.length;i++){
            if (num2Index.containsKey(nums[i])){
                removedIndex.add(i);
                removedIndex.add(num2Index.get(nums[i]));
                num2Index.remove(nums[i]);
                result[0]++;
            }else {
                num2Index.put(nums[i],i);
            }
        }
         Set<Integer> left = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if (removedIndex.contains(i)){
                continue;
            }
            left.add(nums[i]);
        }
        result[1] = left.size();
        return result;
    }

}
