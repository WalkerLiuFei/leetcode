package personal.walker.presum;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC930 implements Solution {
    @Override
    public void runTestCases() {
        numSubarraysWithSum(new int[]{1,0,1,0,1},2);
    }

    /**
     * 暴力解法 ： sum[end] - sum[start] = count
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        Map<Integer,Integer> mapper = new HashMap<>();
        int prefixSum = 0;
        mapper.put(0,1);
        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if (mapper.containsKey(prefixSum - goal)){
                result += mapper.get(prefixSum - goal);
            }
            mapper.put(prefixSum,mapper.getOrDefault(prefixSum,0) + 1);
        }
        return  result;
    }
}
