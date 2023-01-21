package personal.walker.greedy;

import personal.walker.Solution;

import java.util.Stack;

public class LC6202 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(robotWithString("zza"));
//        System.out.println(robotWithString("bdda"));
//        System.out.println(robotWithString("bac"));
//        System.out.println(robotWithString("ccadda"));
//        System.out.println(robotWithString("caaaddddbbbbcccaaa"));
//        System.out.println(robotWithString("bydizfve"));
        System.out.println(robotWithString("vzhofnpo")); // fnohopzv
    }
    public String robotWithString(String s) {
        // 维护一个最小的cahr
        char[] dp = new char[s.length() + 1];
        dp[s.length()] = 'z' + 1;
        for (int i = s.length() - 1; i >= 0;i--){
            dp[i] = dp[i + 1] < s.charAt(i) ?  dp[i+1] : s.charAt(i);

        }
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length();i++){
            stack.push(s.charAt(i));
            while (!stack.isEmpty() && (stack.peek() <= dp[i + 1])){
                builder.append(stack.pop());
            }
        }
        return builder.toString();
    }
}
