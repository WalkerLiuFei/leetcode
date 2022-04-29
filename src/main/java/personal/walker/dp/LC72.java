package personal.walker.dp;

import personal.walker.Solution;

public class LC72 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(minDistance("1","2134"));
        System.out.println(minDistance("h","r"));

        System.out.println(minDistance("horse","ros"));
        System.out.println(minDistance("","ros"));
        System.out.println(minDistance("",""));

    }

    /**
     *
     *  首先我能想到的，两层DP
     *  DP[0][0] = 0
     *  DP[1][0] = 1...DP[w1.length][0] = w1.length
     *  DP[0][1] = 1...DP[0][w2.length] = w2.length
     *  DP[1][1] = if w1[1] == w2[1] : 0,else dp[0][0] + 1
     *  DP[1][2] =
     *      : if w1[2] == w2[1]
     *  DP[i][j] :
     *       if w1[i] == w2[j] ：DP[i][j] = DP[i-1][j-1]
     *       if w1[i] != w2[j] : DP[i][j] = 1 + MIN(DP[i-1][j],DP[i][j-1],DP[i-1][j-1])
     *          explain : DP[i-1][j]标识 w1删除操作 ， DP[i][j-1] 标识w1增加操作 / w2增加操作，DP[i-1][j-1] 标识replace 操作
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0;i < word1.length();i++){
            dp[i+1][0] = i + 1 ;
        }
        for (int i = 0;i < word2.length();i++){
            dp[0][i + 1] = i + 1 ;
        }
        for (int i = 1;i <= word1.length();i++){
            for (int j = 1; j <= word2.length();j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1] );
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
