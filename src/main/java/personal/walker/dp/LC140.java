package personal.walker.dp;

import java.util.*;

public class LC140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // dp[i] = dp[j] && map[s[j:i]]
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        List<List<String>> dp = new ArrayList<>();
        for(int i = 0; i < s.length() + 1; i ++){
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");
        //dp[0] = wordMap.contains(s.substring(0, 1));
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String word = s.substring(j, i);
                if (wordSet.contains(word) && dp.get(j).size() > 0 ) {
                    for (String str : dp.get(j)) {
                        dp.get(i).add(str + (str.length() == 0 ? "" : " ") + word);
                    }
                }
            }
        }
        return dp.get(s.length());
    }
}
