package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC6125 implements Solution {
    @Override
    public void runTestCases() {
      System.out.println( equalPairs(Util.convertTwoDimensionToIntegerArray("[[3,2,1],[1,7,6],[2,7,7]]")));
    }

    public int equalPairs(int[][] grid) {
        HashMap<Integer,Integer> rowHashMap = new HashMap<>();
        HashMap<Integer,Integer> columnHashMap = new HashMap<>();
        for (int[] ints : grid) {
            rowHashMap.putIfAbsent( Arrays.hashCode(ints),0);
            rowHashMap.put(Arrays.hashCode(ints),rowHashMap.get(Arrays.hashCode(ints)) + 1);
        }
        for (int j = 0; j < grid.length; j++){
            int[] column = new int[grid.length];
            for (int i = 0; i < grid.length; i++) {
                column[i] = grid[i][j];
            }
            columnHashMap.putIfAbsent( Arrays.hashCode(column),0);
            columnHashMap.put(Arrays.hashCode(column),columnHashMap.get(Arrays.hashCode(column)) + 1);
        }

         int result = 0;
        for (Map.Entry<Integer,Integer> kv : rowHashMap.entrySet()){
            if (columnHashMap.containsKey(kv.getKey())){
                result += kv.getValue() * columnHashMap.get(kv.getKey());
            }
        }
        return result;
    }

}
