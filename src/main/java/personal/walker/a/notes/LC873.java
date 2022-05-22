package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LC873 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5}));
        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15}));
    }

    /**
     * dp[i] = dp[i-1], dp[nums[i] - ] + 1
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> hTab = new HashMap<>();

        Integer max = 0;
        hTab.put(arr[0],1);
        hTab.put(arr[1],1);
        for (int i = 2; i < arr.length; i++){
            for (int j = i-1; j > 0;j--){
                if (hTab.containsKey(arr[i] - arr[j]) &&  arr[i] - arr[j] < arr[j]){
                    int base = arr[i] - arr[j];
                    int partResult =  Math.max(hTab.getOrDefault(base,1) + 2,hTab.getOrDefault(arr[i],3));
                    if (partResult > max){max=partResult;}
                    hTab.put(arr[i],partResult);
                }
            }
            if (!hTab.containsKey(arr[i])){
                hTab.put(arr[i],1);
            }
        }
        return max;
    }

}
