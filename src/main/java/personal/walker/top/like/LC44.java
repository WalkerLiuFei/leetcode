package personal.walker.top.like;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class LC44 {
    @Builder
    static class Case {
        String s;
        String p;
        boolean result;

        public void run() {
            LC44 lc44 = new LC44();
            boolean r = lc44.isMatch(s, p);
            if (result != r) {
                System.out.printf("s : %s, p: %s ,expect %s, get %s \n",s,p, result, r);
                throw new RuntimeException();
            }
        }
    }

    public void runTestCases() {
       List<Case> caseList = new ArrayList<>();
        caseList.add(Case.builder()
                .s("abccdc")
                .p("*")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("abccdc")
                .p("*c")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("adafafa")
                .p("*fa")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("ad")
                .p("?d")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("efsjgasgjhpaoisjdgoas")
                .p("?*")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("efsjgasgjhpaoisjdgoas")
                .p("e*a*")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("efsjgasgjhpaoisjdgoas")
                .p("e*x*")
                .result(false)
                .build());
        caseList.add(Case.builder()
                .s("efsjgasgjhpaoisjdgoas")
                .p("e*")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("efsjgasgjhpaoisjdgoas")
                .p("f*")
                .result(false)
                .build());
        caseList.add(Case.builder()
                .s("adceb")
                .p("*a*b")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("a")
                .p("*a")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("")
                .p("****")
                .result(true)
                .build());
        caseList.add(Case.builder()
                .s("abcabczzzde")
                .p("*abc???de*")
                .result(true)
                .build());
        for (Case c : caseList){
            c.run();
        }
    }

    /**
     * 类似 https://leetcode.com/problems/regular-expression-matching/
     * 同样是 双数组 DP,
     * 0. dp[0][0] = true, if p[0] == "*" || p[0] == "?"  then ALL dp[0][{p[i]}] = true
     * 1. s[i] == p[j] OR p[j] == "?" then  dp[i][j] = dp[i-1][j-1]
     * 2. p[j] == "*"
     *       1.  匹配零个字符 ： dp[i][j] = dp[i][j-1]
     *       2.  匹配一个字符 ： dp[i][j] = dp[i-1][j-1]
     *       3.  多个字符：     dp[i][j] = dp[i-1][j]
     *
     *
     *
     *  efsaas
     *  e*a*
     *  a[2][2] = a[1][1]
     *  a[2][3] = false
     *  a[2][4] = false
     *  a[3][1] = false
     *  a[3][2] = a[2][1] = true
     *  a[3][3] = false
     *  a[3][4] = false
     *  a[3]
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        if (p.length() < 1){
            return dp[s.length()][0];
        }

        for (int j = 1;j <= p.length();j++){
            if (p.charAt(j-1) == '*') {
                for (int i = 0;i <= s.length();i ++){
                    dp[i][j] = true;
                }
            }else {
                break;
            }
        }

        for (int i = 1;i <= s.length();i++){
            for (int j = 1;j <= p.length();j++){
                if (s.charAt(i - 1) == p.charAt(j -1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    // 如果是 *
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
