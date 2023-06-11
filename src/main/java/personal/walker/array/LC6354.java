package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6354 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k < numOnes){
            return k;
        }
        if (k < numOnes + numZeros){
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }

}
