package personal.walker.greedy;

import personal.walker.Solution;

public class LC2139 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int minMoves(int target, int maxDoubles) {
       int move = 0;
       while (maxDoubles-- > 0 && target > 1){
           // odd
           if ((target & 0x01) != 0){
               move++;
           }
           target >>= 1;

           move++;
       }
       return target - 1 + move;
    }
}
