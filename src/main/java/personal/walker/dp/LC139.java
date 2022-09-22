package personal.walker.dp;

import personal.walker.Solution;

import java.util.*;

public class LC139 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(
                wordBreak("leetcode", Arrays.asList("leet", "code"))
        );
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] = dp[j] && map[s[j:i]]
        Set<String> wordMap = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //dp[0] = wordMap.contains(s.substring(0, 1));
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = wordMap.contains(s.substring(j , i)) && dp[j];
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length() ];
    }
}
