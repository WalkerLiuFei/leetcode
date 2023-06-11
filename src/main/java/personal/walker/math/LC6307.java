package personal.walker.math;

import personal.walker.Solution;

public class LC6307 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int passThePillow(int n, int time) {
         int round = time / (n -1);
        if (round % 2 == 0) {
            return (time % (n - 1)) + 1;
        }
        return   n - (time % (n - 1));

    }

}
