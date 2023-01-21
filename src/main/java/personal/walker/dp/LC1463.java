package personal.walker.dp;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.List;

public class LC1463 implements Solution {
    @Override
    public void runTestCases() {

    }

    class Position {
        int value;
        List<int[]> path;
        public Position(int value,List<int[]> path, int r, int c) {
            this.value = value;
            path.add(new int[]{r,c});
        }
    }


}
