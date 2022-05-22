package personal.walker.sliding.window;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC2260 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int minimumCardPickup(int[] cards) {
        if (cards.length < 2){
            return  0;
        }
        int smallest = Integer.MAX_VALUE >> 1;
        Map<Integer,Integer> num2Index = new HashMap<>();
        for ( int i = 0; i < cards.length ; i++){
            if (num2Index.containsKey(cards[i])){
                smallest = Math.min(smallest,cards[i] - num2Index.get(cards[i]) + 1);
            }
            num2Index.put(cards[i],i);
        }
        if (smallest ==  Integer.MAX_VALUE >> 1){
            return  -1;
        }
        return smallest;
    }
}
