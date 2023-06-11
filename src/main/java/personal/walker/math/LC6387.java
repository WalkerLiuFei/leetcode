package personal.walker.math;

import personal.walker.Solution;

public class LC6387 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return arrivalTime + delayedTime >= 24 ? arrivalTime + delayedTime - 24:arrivalTime + delayedTime;
    }
}
