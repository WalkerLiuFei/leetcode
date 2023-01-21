package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC6230 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println( maximumSubarraySum(new int[]{9,9,9,1,2,3},3));
    }
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0 ;
        int last = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i ++){
            if (map.get(nums[i]) != null){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
            last+= nums[i];
        }
        if (map.size() == k){
            result = last;
        }
        for (int i = 1, j = k; j < nums.length; j ++,i++){
            last -= nums[i - 1];
            last += nums[j];
            map.put(nums[i-1],map.get(nums[i-1]) - 1);
            if (map.get(nums[i-1]) == 0){
                map.remove(nums[i-1]);
            }
            if (map.get(nums[j]) != null){
                map.put(nums[j],map.get(nums[j]) + 1);
            }else {
                map.put(nums[j],1);
            }
            if(map.size() != k){
                continue;
            }
            result = Math.max(result,last);
        }
        return result;
    }


}
