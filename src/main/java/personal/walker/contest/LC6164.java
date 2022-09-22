package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;

public class LC6164 implements Solution {
    @Override
    public void runTestCases() {

    }
    public int maximumSum(int[] nums) {
        int result = -1;
        HashMap<Integer,Integer> pairMaxMap = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++){
            int num = nums[i];
            int sumOfBit = 0 ;
            while (num != 0){
                sumOfBit += num % 10;
                num = num / 10;
            }
            if (pairMaxMap.containsKey(sumOfBit)) {
                result = Math.max(nums[i] + pairMaxMap.get(sumOfBit),result);
                pairMaxMap.put(sumOfBit,Math.max(pairMaxMap.get(sumOfBit),nums[i]));
            }else {
                pairMaxMap.put(sumOfBit,nums[i]);
            }
        }
        return result;
    }

}
