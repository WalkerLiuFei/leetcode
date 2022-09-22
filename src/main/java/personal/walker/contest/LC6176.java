package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC6176 implements Solution {
    @Override
    public void runTestCases() {

    }
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer>  numMap = new HashMap<>();
        int maxFrequent = 0;
        for (int num : nums){
            if ((num & 0x01) != 0){
                continue;
            }
            numMap.putIfAbsent(num,0);
            numMap.put(num,numMap.get(num) + 1);
            if (numMap.get(num) > maxFrequent){
                maxFrequent = numMap.get(num);
            }
        }
        int result = 1<<31-1;
        for(Map.Entry<Integer,Integer> entry : numMap.entrySet()){
            if (entry.getValue() == maxFrequent && result > entry.getKey()){
                result = entry.getKey();
            }
        }
        if (result == 1 << 31 -1){
            return -1;
        }
        return result;
    }
}
