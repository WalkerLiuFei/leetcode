package personal.walker.sort;

import personal.walker.Solution;

import java.util.*;

public class LC646 implements Solution {
    @Override
    public void runTestCases() {

    }

    class Pair {
        int value1;
        int value2;
        Pair(int _value1, int _value2){
            this.value1 = _value1;
            this.value2 = _value2;
        }
    }
    public int findLongestChain(int[][] pairs) {
        if (pairs.length < 1){
            return 0;
        }
        List<Pair> pairList = new ArrayList<>();
        for (int[] pair : pairs){
            pairList.add(new Pair(pair[0],pair[1]));
        }
        Collections.sort(pairList, Comparator.comparingInt(o -> o.value1));
        int[] dp = new int[pairList.size() + 1];
        Arrays.fill(dp,1);
        int result = 1;
        for (int i = 1; i < pairList.size(); i++){
            dp[i] = 1;
            for (int j = i ; j >= 0; j--){
                if (pairList.get(i).value1 > pairList.get(j).value2 ){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    break;
                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
