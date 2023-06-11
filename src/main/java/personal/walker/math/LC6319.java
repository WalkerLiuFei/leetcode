package personal.walker.math;

import personal.walker.Solution;

public class LC6319 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int[] evenOddBit(int n) {
        int count = 0;
        int[] result = new int[]{0,0};
        while (n > 0){
            if (n % 2 == 1 && count % 2 ==0){
                result[0]++;
            }else  if (n % 2 == 1 && count % 2 ==1){
                result[1]++;
            }
            count++;
            n >>= 1;
        }
        return result;
    }
}
