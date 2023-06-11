package personal.walker.matrix;

import personal.walker.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC6440 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] answer = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0;j < grid[0].length; j++){
                Set<Integer> leftSet = new HashSet<>();
                int i1 = i - 1;
                int j1 = j - 1;
                while (i1 >=0 && j1 >=0){
                    leftSet.add(grid[i1][j1]);
                    i1--;
                    j1--;
                }
                Set<Integer> rightSet = new HashSet<>();

                int i2 = i + 1;
                int j2 = j + 1;
                while (i2 < grid.length && j2 < grid[0].length){
                    rightSet.add(grid[i2][j2]);
                    i2++;
                    j2++;
                }
                answer[i][j] = Math.abs(leftSet.size() - rightSet.size());
            }
        }
        return answer;
    }

}
