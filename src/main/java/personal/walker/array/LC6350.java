package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6350 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        int maxScore = 0;
        int maxDivisor = divisors[0];

        for (int divisor : divisors) {
            int score = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }
            if (score > maxScore) {
                maxScore = score;
                maxDivisor = divisor;
            }
        }

        return maxDivisor;
    }

}
