package personal.walker.dp.linear;

import personal.walker.Solution;

import java.util.Arrays;

public class LC1027 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(longestArithSeqLength(new int[]{3,6,9,12}));;
        System.out.println(longestArithSeqLength(new int[]{9,4,7,2,10}));
        System.out.println(longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
        System.out.println(longestArithSeqLength(new int[]{3,5,6,11}));;

    }
    /**
     *  for i -> 0...nums.length -1
     *    for j -> 0....i
     *  dp[j][nums[j] - nums[i]] = dp[i][nums[j] - nums[i]] + 1
     *  result = max(result,dp[j][diff])
     */

    public int longestArithSeqLength(int[] nums) {
        int[][] positiveDP = new int[nums.length][500];
        int[][] negativeDP = new int[nums.length][500];
        for (int[] dp : positiveDP){
            Arrays.fill(dp,1);
        }
        for (int[] dp : negativeDP){
            Arrays.fill(dp,1);
        }
        int result = 2;
        for (int i = 0; i < nums.length;i++){
            for (int j = 0; j < i;j++){
                int diff = nums[j] - nums[i];
                if (diff < 0){
                    negativeDP[i][Math.abs(diff)] = negativeDP[j][Math.abs(diff)] + 1;
                    result = Math.max(negativeDP[i][Math.abs(diff)],result);
                }else {
                    positiveDP[i][Math.abs(diff)] = positiveDP[j][Math.abs(diff)] + 1;
                    result = Math.max(positiveDP[i][Math.abs(diff)],result);
                }
            }
        }
        return result;
    }
}
