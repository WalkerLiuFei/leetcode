package personal.walker.array;

import personal.walker.Solution;

import java.util.Stack;

public class LC838 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(pushDominoes("RR.L"));
        System.out.println(pushDominoes(".L.R...LR..L.."));
        System.out.println(pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        char[] result = new char[dominoes.length()];
        Stack<Integer> stack = new Stack<>();
        boolean hasRightPush = false;
        for (int i = 0; i < dominoes.length(); i++) {

            if (dominoes.charAt(i) == 'L') {
                stack.push(i);
                if (hasRightPush) {
                    // 如果有right push 将其中的一半拿出来set 为L
                    int srcSize = stack.size() ;
                    for (int count = srcSize / 2; count > 0; count--) {
                        result[stack.pop()] = 'L';
                    }
                    if (srcSize % 2 == 1) {
                        result[stack.pop()] = '.';
                    }
                    // clear stack.
                    while (!stack.isEmpty()){
                        result[stack.pop()] = 'R';
                    }
                } else {
                    while (!stack.isEmpty()) {
                        result[stack.pop()] = 'L';
                    }
                }
                hasRightPush = false;
                continue;
            }
            if (dominoes.charAt(i) == 'R') {
                while (!stack.isEmpty()) {
                    result[stack.pop()] = hasRightPush ? 'R' : '.';
                }
                hasRightPush = true;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){

            while (!stack.isEmpty()) {
                result[stack.pop()] = hasRightPush ? 'R' : '.';
            }
        }
        return new String(result);
    }
}
