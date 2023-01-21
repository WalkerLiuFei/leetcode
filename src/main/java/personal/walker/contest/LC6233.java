package personal.walker.contest;

import personal.walker.Solution;

public class LC6233 implements Solution {
    @Override
    public void runTestCases() {

    }

    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32.00};
    }
}
