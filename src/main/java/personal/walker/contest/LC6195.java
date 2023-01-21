package personal.walker.contest;

import personal.walker.Solution;

public class LC6195 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(deleteString("abcabcdabc"));
        System.out.println(deleteString("aaaaa"));
        System.out.println(deleteString("aaabaab"));
    }
    public int deleteString(String s) {
        //int[] occur = new int[26];
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int waitIndex = 0;

        for (int i = 1; i < s.length();i++ ){
            if ((i - waitIndex + 1) % 2 != 0 && s.charAt((i - waitIndex + 1) / 2) != s.charAt(waitIndex)) {
                dp[i] = dp[i - 1];
                continue;
            }
            if (!diffTwoIndex(s,waitIndex,i)){
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Math.max(dp[i],dp[waitIndex] + 1);
            waitIndex = waitIndex + ((i - waitIndex + 1) / 2);
        }
        return dp[s.length()-1];
    }

    boolean diffTwoIndex(String s, int a, int b){
        StringBuilder aStrBuilder = new StringBuilder();
        for (int i = a; i < b; i++){
            aStrBuilder.append(s.charAt(i));
        }
        StringBuilder bStrBuilder = new StringBuilder();
        for (int i = b; i < s.length() && i < b + (b - a); i++){
            bStrBuilder.append(s.charAt(i));
        }
        return aStrBuilder.toString().equals(bStrBuilder.toString());
    }
}
