package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6160 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answerArray = new int[queries.length];
        Arrays.sort(nums);
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int j = 1;   j < nums.length; j ++){
            preSum[j] = preSum[j] + preSum[j - 1] + nums[j];
        }
        for (int i = 0; i < queries.length;i++){
            //FIXME : binary search
            int answer = 0;
            for (int j = 0;   j < nums.length; j ++){
                if (preSum[j] > queries[i]){
                    break;
                }
                answer++;
            }
            answerArray[i] = answer;
        }
        return answerArray;
    }
}
