package personal.walker.dp;

import personal.walker.Solution;

public class LC6455 implements Solution {
    @Override
    public void runTestCases() {

    }


    public long minimumCost(String s) {
        int n = s.length();
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        dp0[0] = s.charAt(0) == '1' ? 1 : 0;
        dp1[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp0[i] = Math.min(dp0[i - 1] + (s.charAt(i) == '1' ? 1 : 0), dp1[i - 1] + i + 1);
            dp1[i] = Math.min(dp1[i - 1] + (s.charAt(i) == '0' ? 1 : 0), dp0[i - 1] + i + 1);
        }
        return Math.min(dp0[n - 1], dp1[n - 1]);
    }
}
