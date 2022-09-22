package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC6128 implements Solution {
    @Override
    public void runTestCases() {

    }

    public String bestHand(int[] ranks, char[] suits) {
        char suit = suits[0];
        int i = 0;
        boolean flag = true;
        while (i < suits.length ){
            flag = suits[i++] == suit;
            if (!flag){break;}
        }
        if (flag){
            return "Flush";
        }
        Map<Integer,Integer> rankMap = new HashMap<>();
        for (int rank : ranks){
            if (rankMap.get(rank) == null){
                rankMap.put(rank,1);
            }else if (rankMap.get(rank) == 2){
                return "Three of a Kind";
            }else {
                rankMap.put(rank,rankMap.get(rank)+1);
            }
        }
        if (rankMap.size() == 5){
            return "High Card";
        }
        return "Pair";
    }

}
