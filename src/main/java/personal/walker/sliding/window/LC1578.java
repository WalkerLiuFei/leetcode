package personal.walker.sliding.window;

import personal.walker.Solution;

public class LC1578 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int minCost(String colors, int[] neededTime) {
        int result = 0;
        int i = 0;
        while (i < colors.length()) {
            int max = neededTime[i];
            int sumSpend = 0;
            int j = i + 1;
            while (j < colors.length() && colors.charAt(j) == colors.charAt(i)) {
                if (neededTime[j] > max) {
                    sumSpend += max;
                    max = neededTime[j];
                } else {
                    sumSpend += neededTime[j];
                }
                j++;
            }
            result += sumSpend;
            i = j;
        }
        return result;
    }
}
