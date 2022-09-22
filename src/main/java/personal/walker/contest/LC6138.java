package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6138 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(longestIdealString("acfgbd",2));
        System.out.println(longestIdealString("slddedwfmo", 16));
        System.out.println(longestIdealString("znrkjnk", 8));

    }

    public int longestIdealString(String s, int k) {
        int result = 0;
        int[] dp = new int[26];
        int[] latestIndex = new int[26];
        Arrays.fill(latestIndex,1 << 31 - 1);
        for (int index = 0; index < s.length(); index++) {
            char b = s.charAt(index);
            int dpIndex = b - 'a';
            dp[dpIndex] = Math.max(1,dp[dpIndex]);
            int newLength = dp[dpIndex];
            for (int c = -k; c <= k; c++) {
                if (b + c < 'a' || b + c > 'z' ) {
                    continue;
                }
                if (latestIndex[b + c - 'a'] >= index){
                    continue;
                }
                newLength = Math.max(dp[dpIndex + c] + 1, newLength);
            }
            dp[dpIndex] = newLength;
            latestIndex[b - 'a'] = index;
            result = Math.max(dp[b - 'a'], result);
        }
        return result;
    }
}
