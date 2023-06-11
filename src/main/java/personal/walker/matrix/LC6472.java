package personal.walker.matrix;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.HashMap;

public class LC6472 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(matrixSumQueries(3, Util.convertTwoDimensionToIntegerArray("[[0,0,1],[1,2,2],[0,2,3],[1,0,4]]")));
    }

    public long matrixSumQueries(int n, int[][] queries) {
        long result = 0;
        int columnNum = n;
        int rowNum = n;
        boolean[] columnSet = new boolean[n];
        boolean[] rowSet = new boolean[n];
        for (int i = queries.length - 1; i >= 0; i --){
            int[] query = queries[i];
            if (query[0] == 0 && !rowSet[query[1]]) {
               rowNum--;
               rowSet[query[1]] = true;
               result += (long) query[2] * columnNum;
            }

            if (query[0] == 1 && !columnSet[query[1]]) {
                columnNum--;
                columnSet[query[1]] = true;
                result += (long) query[2] * rowNum;
            }
         }
        return result;
    }
}
