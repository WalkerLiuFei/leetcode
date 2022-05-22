package personal.walker.stack;

import personal.walker.Solution;

import java.util.Stack;

public class LC1047 implements Solution {
    @Override
    public void runTestCases() {

    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for (Character character : s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() == character){
                stack.pop();
                continue;
            }
            stack.push(character);
        }
        char[] charArray = new char[stack.size()];
        int index = stack.size();
        while (!stack.isEmpty()){
            charArray[--index] = stack.pop();
        }
        return new String(charArray);
    }
}
