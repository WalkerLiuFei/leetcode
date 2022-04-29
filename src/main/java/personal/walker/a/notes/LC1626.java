package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.Arrays;

public class LC1626 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(bestTeamScore(new int[]{4,5,6,5},new int[]{2,1,2,1}));
//        System.out.println(bestTeamScore(new int[]{1,3,5,10,15},new int[]{1,2,3,4,5}));
        System.out.println(bestTeamScore(new int[]{1,2,3,5},new int[]{8,9,10,1}));
    }

    /**
     * initial : dp[age] = max(score)
     * for all age <= ages[i]
     * dp[age] = max(dp[age],dp[age] + scores[i])
     * dp[0][0] = 0
     *  scores = [4,5,6,5], ages = [2,1,2,1]
     *  maxAge = 2
     *  i = 0 : dp[1] = 4; dp[2] = 4
     *  i = 1 : dp[1] = MAX(dp[1],dp[0] + scores[])
     *
     *
     * @param scores
     * @param ages
     * @return
     */
    int res = 0;
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] team = new int[len][2];
        for (int i = 0; i < len; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i]; // team is [age, score]
        }
        // double sort first by age then by score, then we can traverse from young to old
        Arrays.sort(team, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[len];
        // dp is the max sum for all sequences (not necessarily consecutive) ending in current idx
        dp[0] = team[0][1];
        for (int i = 1; i < len; i++) {
            int max = team[i][1];
            // At least it could start a new sequence by itself without extend
            // for each current idx, go visit all previous index to grow the sequences
            for (int j = 0; j < i; j++) {
                if (team[i][1] >= team[j][1]) {
                    max = Math.max(max, dp[j] + team[i][1]);
                }
            }
            dp[i] = max;
        }

        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }

        return res;
    }
}
