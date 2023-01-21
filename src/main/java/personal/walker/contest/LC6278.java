package personal.walker.contest;

import personal.walker.Solution;

public class LC6278 implements Solution {

    @Override
    public void runTestCases() {

    }

    public int countDigits(int num) {
        int tmp = num;
        int result =0;
        while (tmp > 0){
            result += num % (tmp % 10) == 0 ? 1 : 0;
            tmp /= 10;
        }
        return result;
    }
}

