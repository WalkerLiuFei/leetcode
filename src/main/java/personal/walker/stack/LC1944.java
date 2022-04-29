package personal.walker.stack;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.ArrayDeque;
import java.util.Stack;

public class LC1944 implements Solution {
    @Override
    public void runTestCases() {
        Gson gson = new Gson();
        String countStr = gson.toJson(canSeePersonsCount(new int[]{5,1,2,3,10}));
        System.out.println(countStr);



        countStr = gson.toJson(canSeePersonsCount(new int[]{10,9,8,7,6,5}));
        System.out.println(countStr);

        countStr = gson.toJson(canSeePersonsCount(new int[]{10,6,8,5,11,9}));
        System.out.println(countStr);

          countStr = gson.toJson(canSeePersonsCount(new int[]{11,19,12,15,14,18,7,1,8,9}));
        System.out.println(countStr);
    }


    /**
     * 将move people into stack,直到
     * [10,6,8,5,11,9]
     * 1. 10 先入栈
     * 2. 6  10 入栈，10可以看到6，栈顶 + 1
     * 3. 8 由于8 > 6 ,所以6 + 1出栈，8入栈，8入栈时 栈顶10 + 1
     * 5. 5 由于5小于栈顶8，5入栈，切栈顶 8 + 1
     * 6. 11 11 > 栈顶元素5，5出栈 + 1，,8出栈 + 1，,10 出栈 + 1
     * 。。。。。
     */

    class People {
        int index;
        int height;
        int inSight;

        People(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }


    public int[] canSeePersonsCount(int[] heights) {
        int[] result = new int[heights.length];

        ArrayDeque<People> stack = new ArrayDeque();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && stack.peek().height < heights[i]) {
                People top = stack.pop();
                result[top.index] = ++top.inSight;
            }
            // 栈顶元素 +1
            if (!stack.isEmpty()){
                stack.peek().inSight++;
            }
            stack.push(new People(i, heights[i]));
        }
        while (!stack.isEmpty()) {
            People top = stack.pop();
            result[top.index] = top.inSight++;
        }
        return result;
    }
}
