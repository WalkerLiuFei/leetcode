package personal.walker.assessment;

import personal.walker.Solution;

public class LC1351 implements Solution {

    @Override
    public void runTestCases() {

    }


    public int countNegatives(int[][] grid) {
        int result =0;
        for (int[] ints : grid) {
            for (int j = 0; j < ints.length; j++) {
                result += ints[j] < 0 ? 1 : 0;
            }
        }
        return result;
    }
}
