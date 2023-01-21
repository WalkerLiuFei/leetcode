package personal.walker.contest;

import personal.walker.Solution;

public class LC6220 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int averageValue(int[] nums) {
        int count =0;
        int sum = 0;
        for (int num : nums){
            if (num % 2 == 0 && num % 3 == 0){
                count++;
                sum += num;
            }
        }
        if (count == 0){
            return 0;
        }
        return sum / count;

    }

}
