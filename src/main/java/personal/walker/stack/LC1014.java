package personal.walker.stack;

import personal.walker.Solution;

import java.util.Stack;

public class LC1014 implements Solution {
    @Override
    public void runTestCases() {

    }


    private class Element {
        int index;
        int value;

        public Element(int value , int index ) {
            this.index = index;
            this.value = value;
        }
    }
    public int maxScoreSightseeingPair(int[] values) {
        Stack<Element> stack = new Stack<>();
        int[] mem = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            while (!stack.isEmpty() ) {
                Element top = stack.peek();
                if (stack.peek().value < values[i]){
                    top = stack.pop();
                }
                mem[i] = Math.max(mem[i], values[i] + top.value + top.index - i);
                if (top.value >= values[i]){
                    break;
                }
            }
            stack.push(new Element(values[i],i));
        }
        int max = 0;
        for (int j : mem) {
            max = Math.max(max, j);
        }
        return max;
    }

}
