package personal.walker.string;

import personal.walker.Solution;

import java.util.Stack;

public class LC1221 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int balancedStringSplit(String s) {
        Stack<Byte> stack = new Stack<>();
        int result = 0;
        for (byte b : s.getBytes()){

            if (stack.peek() == b){
                stack.push(b);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    result++;
                }
            }
        }
        return result;
    }
}
