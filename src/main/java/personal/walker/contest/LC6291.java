package personal.walker.contest;

import personal.walker.Solution;

public class LC6291 implements Solution {

    @Override
    public void runTestCases() {

    }

    public int differenceOfSum(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums){
            sum1 += num;
            int tmp = num;
            while (tmp > 0){
                sum2 += tmp % 10;
                tmp /= 10;
            }
        }
        return Math.abs(sum1 - sum2);
    }
}
