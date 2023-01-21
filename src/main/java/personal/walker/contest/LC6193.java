package personal.walker.contest;

import personal.walker.Solution;

public class LC6193 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int maxSum(int[][] grid) {
        int max_sum = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length - 2; i++) {

            for (int j = 0; j < grid[0].length -2; j++) {
                // Considering mat[i][j] as top
                // left cell of hour glass.
                int sum = (grid[i][j] + grid[i][j + 1] +
                        grid[i][j + 2]) + (grid[i + 1][j + 1]) +
                        (grid[i + 2][j] + grid[i + 2][j + 1] +
                                grid[i + 2][j + 2]);
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    static int R = 5;
    static int C = 5;

    static int findMaxSum(int[][] mat) {
        if (R < 3 || C < 3) {
            System.out.println("Not possible");
            System.exit(0);
        }

        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                // Considering mat[i][j] as top
                // left cell of hour glass.
                int sum = (mat[i][j] + mat[i][j + 1] +
                        mat[i][j + 2]) + (mat[i + 1][j + 1]) +
                        (mat[i + 2][j] + mat[i + 2][j + 1] +
                                mat[i + 2][j + 2]);


                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }
}
