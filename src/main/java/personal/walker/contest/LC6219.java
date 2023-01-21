package personal.walker.contest;

import personal.walker.Solution;


public class LC6219 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println( sumOfNumberAndReverse(6));;
        System.out.println( sumOfNumberAndReverse(0));;

    }

    public boolean sumOfNumberAndReverse(int num) {
        for (int temp = num / 10; temp <= num; temp++) {
            int tempCpy = temp;
            int reverse = 0;
            while (tempCpy != 0){
                reverse = reverse * 10  + tempCpy % 10;
                tempCpy /= 10;
            }
            if (reverse + temp == num){
                return true;
            }
        }
        return false;
    }
}
