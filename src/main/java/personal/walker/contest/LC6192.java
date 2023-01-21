package personal.walker.contest;

import personal.walker.Solution;

public class LC6192 implements Solution {
    @Override
    public void runTestCases() {

    }
    public int commonFactors(int a, int b) {
        int result = 0;
        for (int i = 0; i <= Math.min(a,b);i ++){
            if (a % i == 0 && b % i == 0){
                result++;
            }
        }
        return result;
    }
}
