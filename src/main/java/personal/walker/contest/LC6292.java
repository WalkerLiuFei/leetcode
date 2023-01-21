package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;

public class LC6292 implements Solution {
    @Override
    public void runTestCases() {
        rangeAddQueries(3,new int[][]{{1,1,2,2},{0,0,1,1}});
    }
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];
        for (int i = 0 ; i  < queries.length;i++){
            for (int j = queries[i][0]; j < queries[i][2];j++){
                for (int k = queries[i][1];k < queries[i][3];k++){
                    result[j][k]++;
                }
            }
        }
        return result;
    }
}
