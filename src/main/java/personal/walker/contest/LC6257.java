package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC6257 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int deleteGreatestValue(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < grid.length;i ++){
            Arrays.sort(grid[i]);
        }
        for (int i = 0; i < grid[0].length;i ++){
            int max = 0;
            for (int[] ints : grid) {
                max = Math.max(ints[i], max);
            }
            result += max;
        }
        return result;
    }

}
