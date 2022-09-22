package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6141 implements Solution {
    @Override
    public void runTestCases() {

    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> value2Weight = new HashMap<>();
        for (int index = 0; index < items1.length;index++){
            value2Weight.put(items1[index][0],items1[index][1]);
        }
        for (int index = 0; index < items2.length;index++){
            if (value2Weight.get(items2[index][0]) == null){
                value2Weight.put(items2[index][0],items2[index][1]);
            }else {
                value2Weight.put(items2[index][0],value2Weight.get(items2[index][0]) +items2[index][1]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer,Integer> set : value2Weight.entrySet()){
            result.add(Arrays.asList(set.getKey(),set.getValue()));
        }
        Collections.sort(result, Comparator.comparingInt(o -> o.get(0)));
        return result;
    }
}
