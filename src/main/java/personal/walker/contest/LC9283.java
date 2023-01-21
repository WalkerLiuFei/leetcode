package personal.walker.contest;

import personal.walker.Solution;

public class LC9283 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int maximumCount(int[] nums) {
        int n = 0;
        int p = 0;
        for (int num :nums){
            if (num < 0){
                n++;
            }
            if (num > 0){
                p++;
            }
        }
        return Math.max(n,p);
    }
}
