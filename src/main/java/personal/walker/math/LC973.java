package personal.walker.math;

import personal.walker.Solution;

import java.util.*;

public class LC973 implements Solution {
    @Override
    public void runTestCases() {

    }

    class Result {
        int value;
        int[] point;

        public Result(int value, int[] point) {
            this.value = value;
            this.point = point;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        Result[] resultArray = new Result[points.length];
        for (int i = 0; i < points.length; i++){
            resultArray[i] = new Result((points[i][0] * points[i][0] + points[i][1] * points[i][1]),points[i]);
        }
        Arrays.sort(resultArray, Comparator.comparingInt(o -> o.value));
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++){
            result[i] = resultArray[i].point;
        }
        return result;
    }
}
