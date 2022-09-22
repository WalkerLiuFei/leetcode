package personal.walker.string;

import personal.walker.Solution;

import java.util.Stack;

public class LC557 implements Solution {
    @Override
    public void runTestCases() {

    }

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                while (!stack.isEmpty()) {
                    builder.append(stack.pop());
                }
                builder.append(' ');
                continue;
            }
            stack.push(c);
        }
        return builder.toString();
    }
}
