package personal.walker.array;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC6317 implements Solution {
    @Override
    public void runTestCases() {

    }


    public long beautifulSubarrays(int[] nums) {
        long count = 0;
        Map<Long, Integer> xorMap = new HashMap<>();
        long xorSum = 0;
        xorMap.put(0L, 1); // 异或和为0的情况，出现次数为1
        for (int i = 0; i < nums.length; i++) {
            xorSum ^= nums[i];
            if (xorMap.containsKey(xorSum)) {
                count += xorMap.get(xorSum);
            }
            xorMap.put(xorSum, xorMap.getOrDefault(xorSum, 0) + 1);
        }
        return count;
    }


}
