package personal.walker.contest;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC6222 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(makeIntegerBeautiful(467,6));
        System.out.println(makeIntegerBeautiful(16,6));
        System.out.println(makeIntegerBeautiful(1,1));
        System.out.println(makeIntegerBeautiful(500,4));
        System.out.println(makeIntegerBeautiful(601,4));
    }

    public long makeIntegerBeautiful(long n, int target) {
        //int[] dp = new int[];
        int[] digits = new int[String.valueOf(n).length()];
        int sumDigit = 0;
        long temp = n;
        for (int i = 0; temp > 0; i++) {
            digits[i] = (int) (temp % 10);
            temp /= 10;
            sumDigit += digits[i];
        }
        if (sumDigit <= target){
            return 0;
        }
        long result = 0;
        // int power = 0;
        // 优先低位变成 零
        boolean carry = false;
        for (int i = 0; i < digits.length; i++){

            int src = digits[i];
            if (carry){
               src += 1;
            }
            if (src == 0){
                continue;
            }
            result += (10 - src) * Math.pow(10,i);
            carry = true;
            sumDigit -= (src - 1);
            if (sumDigit <= target){
                break;
            }
        }
        return result;
    }

}
