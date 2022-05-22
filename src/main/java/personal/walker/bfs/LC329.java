package personal.walker.bfs;

import personal.walker.Solution;

import java.util.Arrays;

public class LC329 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * if memory[i][j] != means visited， then + 1,
     * 考虑一个
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memories = new int[matrix.length][matrix[0].length];
        // has been visited
        // for (int[] memory : memories){
        //     Arrays.fill(memory,1);
        // }
        int result = 1;
        for (int i = 0; i < matrix.length;i++){
            for (int j = 0; j < matrix[0].length;j++){
                // not visted
                if (memories[i][j] == 0){
                    dfs(matrix,i,j,memories);
                }
                result = Math.max(memories[i][j],result);
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int dfs(int[][] matrix, int i, int j, int[][] memory){
        if (memory[i][j] > 1 ){
            return memory[i][j];
        }
        int max = 1;
        for (int[] direction : directions){
            int in = i + direction[0];
            int jn = j + direction[1];
            if (in < 0 || in >= matrix.length || jn < 0 || jn >= matrix[0].length){
                continue;
            }
            if (matrix[i][j] < matrix[in][jn]){
                int directionLen = dfs(matrix,in,jn,memory) + 1;
                max = Math.max(directionLen,max);
            }
        }
        memory[i][j] = max;
        return memory[i][j];
    }
}
