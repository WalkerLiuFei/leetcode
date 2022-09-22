package personal.walker.contest;

import personal.walker.Solution;

public class LC6148 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length-2][grid.length-2];
        for (int i = 0; i < grid.length-2; i++){
            for (int j = 0; j < grid.length - 2; j++){
                int max = grid[i][j];
                for (int c1 = 0; c1 < 3; c1++){
                    for (int c2 = 0; c2 < 3; c2++){
                        if (grid[i + c1][j + c2] > max){
                            max = grid[i + c1][j + c2];
                        }
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}
