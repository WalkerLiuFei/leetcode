package personal.walker.presum;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.Util;

public class LC238 implements Solution {
    @Override
    public void runTestCases() {
        Util.printResult(productExceptSelf(new int[]{1,2,3,4}));
        Util.printResult(productExceptSelf(new int[]{-1,1,0,-3,3}));

    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProduct = new int[n];
        int[] tailProduct = new int[n];
        int[] result = new int[n];
        preProduct[0] = nums[0];
        for (int i = 1; i < n;i++){
            preProduct[i] = preProduct[i-1] * nums[i];
        }
        tailProduct[nums.length-1] = nums[nums.length-1];
        for (int i = n - 2; i >= 0;i--){
            tailProduct[i] = tailProduct[i+1] * nums[i];
        }
        result[0] = tailProduct[1];
        result[n -1] = preProduct[n-2];
        for (int i = 1; i < nums.length-1;i++){
            result[i] = preProduct[i-1] * tailProduct[i + 1];
        }
        return result;
    }
}
