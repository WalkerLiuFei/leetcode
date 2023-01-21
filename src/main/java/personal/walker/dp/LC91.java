package personal.walker.dp;

import personal.walker.Solution;

public class LC91 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(numDecodings("23"));
        System.out.println(numDecodings("122222"));
    }

    // 1222
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0'){
            return 0;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] = dp[i];
            }
            if (s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                return 0;
            }else if (s.charAt(i) == '0' && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')){
                dp[i + 1] = dp[i - 1];
                continue;
            }
            if (s.charAt(i - 1) == '1' ||
                    (s.charAt(i - 1) == '2' && (s.charAt(i) > '0' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
