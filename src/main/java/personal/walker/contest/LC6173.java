package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.Map;

public class LC6173 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(maximumRows(Util.convertTwoDimensionToIntegerArray("[[0,0,0],[1,0,1],[0,1,1],[0,0,1]]"), 2));
        System.out.println(maximumRows(Util.convertTwoDimensionToIntegerArray("[[1],[0]]"), 1));
        System.out.println(maximumRows(Util.convertTwoDimensionToIntegerArray("[[0,0],[0,1],[0,0],[1,1]]"), 1));
        System.out.println(maximumRows(Util.convertTwoDimensionToIntegerArray("[[0,0,1,1,1]]"), 3));
        System.out.println(maximumRows(Util.convertTwoDimensionToIntegerArray("[[1,0,1,0,1,0]]"), 3));
    }

    /**
     * take 0-cols get a result
     * take 1-cols get a result
     * ....
     * take cols -k,
     *
     * @param mat
     * @param cols
     * @return
     */
    public int maximumRows(int[][] mat, int cols) {
        if (cols == mat[0].length) {
            return mat.length;
        }
        // sliding windowing, cycle 0 - cols
        return recursive(mat,cols,0,new boolean[mat[0].length]);
    }
    public int recursive(int[][] mat, int left, int currentColumn, boolean[] takeMap) {
        if (left == 0) {
            return traverse(mat, takeMap);
        }
        if (currentColumn == mat[0].length){
            return traverse(mat, takeMap);
        }
        int result = 0;
        // take or not take
        takeMap[currentColumn] = true;
        result = Math.max(recursive(mat, left - 1, currentColumn + 1, takeMap), result);
        takeMap[currentColumn] = false;
        result = Math.max(result, recursive(mat, left, currentColumn + 1, takeMap));
        return result;
    }

    public int traverse(int[][] mat, boolean[] take) {
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            boolean flag = true;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && !take[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }
}
