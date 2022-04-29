package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6041 implements Solution {
    @Override
    public void runTestCases() {

    }
    public List<Integer> intersection(int[][] nums) {

        List<Set<Integer>> setList  = new ArrayList<>();
        Set<Integer> allNums = new HashSet<>();
        for (int i = 0; i < nums.length;i++){
            Set<Integer> integerSet = new HashSet<>();
            for (int j = 0; j < nums[i].length;j++){
                integerSet.add(nums[i][j]);
                allNums.add(nums[i][j]);
            }
            setList.add(integerSet);
        }

        Iterator<Integer> iterator = allNums.iterator();
        Set<Integer> remove = new HashSet<>();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            for (int i = 1; i < setList.size(); i++){
                if (!setList.get(i).contains(integer)){
                    remove.add(integer);
                }
            }
        }
        allNums.removeAll(remove);
        List<Integer> result = new ArrayList<Integer>(allNums);
        Collections.sort(result);
        return result;
    }

}
