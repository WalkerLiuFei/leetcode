package personal.walker.dp;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC446 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
       System.out.println(numberOfArithmeticSlices(new int[]{2, 2, 4, 4, 6, 6}));

       System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
    }


    /**
     * dp :  set dp as HashMap.
     * for i => 2...nums.length
     * for j => i-1....0
     * if (dp[i-j] >= 1 && dp[i-j] ++ >= 3){
     * // make length increase
     * dp[i-j]++;
     * }
     * dp[i][j] = dp[]
     * <p>
     * <p>
     * dp[i][d] = dp[i-d][d] + 1
     * 2 : 2
     * 4 : 2,
     * 1. 首先考虑一个情况，如果nums 中数据一样的元素，顺序是无所谓的，数量是有所谓的
     * 2. 公式是没问题的 dp[nums[i]][distance] = dp[i][j - (i - j)] + 1
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {

        Gson gson = new Gson();

        int ans = 0;
        // dp[num][distance] = dp[num - distance][distance] + 1

        // 去重,num of element
        Map<Integer,Integer> countOfElement = new HashMap<>();
        for (int num : nums){
            countOfElement.put(num, countOfElement.getOrDefault(num,0) + 1);
        }

        Integer[] numArray = countOfElement.keySet().toArray(new Integer[]{});
        // sort
        Arrays.sort(numArray);
        Map<Integer, Map<Integer, Integer>> diffMap = new HashMap<>();
        for (Integer key : countOfElement.keySet()){
            Map<Integer,Integer> hashMap = new HashMap<>();
            hashMap.put(0,countOfElement.get(key));
            diffMap.put(key,hashMap);
        }


        // int[][] dp = new int[nums.length][nums.length];
      //  diffMap.put(nums[0], new HashMap<>());
        for (int i = 1; i < numArray.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                Map<Integer, Integer> currentHashMap = diffMap.getOrDefault(numArray[i], new HashMap<>());
                Map<Integer, Integer> preMap = diffMap.get(numArray[j]);
                int distance = numArray[i] - numArray[j];
                // same,continue, 防止distance 为0的情况重复计算
                // 说明 nums[i] -
                if (preMap != null && preMap.get(distance) != null) {
                    currentHashMap.put(distance, preMap.get(distance) + 1);
                } else {
                    currentHashMap.put(distance, 2);
                }
                diffMap.put(numArray[i], currentHashMap);
            }
        }
        System.out.println(gson.toJson(diffMap));

        for (int i = 1; i < numArray.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
            }
        }
        for (int i = numArray.length - 1; i >= 0; i--) {
            for (Map.Entry<Integer,Integer> entry : diffMap.get(numArray[i]).entrySet()){
                if (entry.getValue() >= 3 && entry.getKey() != 0){

                }
            }
        }

//
//        for (Map.Entry<Integer,Map<Integer, Integer>> entryMap: diffMap.entrySet()) {
//            for (Map.Entry<Integer,Integer> entry : entryMap.getValue().entrySet()){
//                // 最大的元素
//                int top = entryMap.getKey();
//                // diff
//                int diff = entry.getKey();
//                // length
//                int length = entry.getValue();
//                // 不符合条件，continue
//                if (length < 3){
//                    continue;
//                }
//                // 例如 2,2,4,4,6,6 ，要找到有多少个2，多少个4，这样，计算出正确的diff指定的数字。
//
//
//                int partAns = 0;
//                for (int count = entry.getKey() - 2; count > 0; count--) {
//                    partAns += count;
//                }
//                Map<Integer, Integer> distanceMap = diffMap.get(top);
//                while (distanceMap != null) {
//                    if (distanceMap.get(0) != null && distanceMap.get(0) > 0) {
//                        partAns = partAns * distanceMap.get(0);
//                    }
//
//
//                    distanceMap = diffMap.get(top);
//                }
//                ans += partAns;
//            }
//
//
//        }
        return ans;
    }

}
