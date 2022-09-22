package personal.walker.contest;

import personal.walker.Solution;

public class LC6105 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * num[i] & (nums[i] XOR X) : 最高位可以确定，所以动最高位没有意义，
     * 11, 10,100,110
     * 1, 10,11,1001,10,
     *
     * 11 : 1011
     * 7  :
     * @param nums
     * @return
     */

    public int maximumXOR(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < nums.length;i++){
            result |= nums[i];
        }
        return result;
    }
}
