package personal.walker.sliding.window;

import personal.walker.Solution;

public class LC2134 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int minSwaps(int[] nums) {
        int oneCount = 0;
        for (int num : nums){
            oneCount += num;
        }
        if (oneCount == 0 || oneCount == nums.length){
            return 0;
        }
        int start = 0;
        int end = start + oneCount;
        int result = 0;
        for (int i = start;i < end; i++){
            result += nums[i] == 0 ? 1 : 0;
        }
        int windowSwap = result;
        while (start < nums.length){
            if (nums[start++] == 0){
                windowSwap--;
            }
            if (nums[end++] == 0){
                windowSwap++;
            }
            if (end == nums.length){
                end = 0;
            }
            result = Math.min(windowSwap,result);
        }
        return result;
    }


}
