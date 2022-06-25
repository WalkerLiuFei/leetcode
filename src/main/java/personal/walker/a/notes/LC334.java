package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.Stack;

public class LC334 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * first = MAX_INTEGER
     * second = MAX_INTEGER
     * if num < first:
     *    first = num
     *    second = MAX_INTEGER
     * example :
     * 1,2,0,3
     * 1,2,0,1,2
     *
     *
     *  ***greedy 算法，不需要具体的数值，需要满足即可***
     *
     * @param nums
     * @return
     */
    static int MAX = Integer.MAX_VALUE >> 1;
    public boolean increasingTriplet(int[] nums) {
            return false;
    }

}
