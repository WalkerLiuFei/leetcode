package personal.walker.array;

import personal.walker.Solution;

public class LC485 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int current = 0;
        for (int num : nums){
            if (num == 1){
                current++;
                if (current > result){
                    result = current;
                }
            }
            if (num == 0){
                current = 0;
            }
        }
        return result;
    }
}
