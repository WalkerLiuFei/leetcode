package personal.walker.sliding.window;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6329 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println( makeSubKSumEqual(new int[]{2,5,5,7},3));
    }

    public long makeSubKSumEqual(int[] arr, int k) {
        long[] prefixSum = new long[arr.length];
        for (int i = 0; i < k; i++) {
            prefixSum[0] += arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] - arr[i - 1] + arr[(i + k - 1) % arr.length];
        }
        long prefixSumSum = 0;
        for (long sum : prefixSum) {
            prefixSumSum += sum;
        }
        System.out.println(Arrays.toString(prefixSum));
        System.out.println(prefixSumSum);
        return 0;
    }

}
