package personal.walker.stack;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
public class LC496 implements Solution {
    @Override
    public void runTestCases() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(nextGreaterElement(new int[]{4,2,5},new int[]{5,2,3,4})));
        System.out.println(gson.toJson(nextGreaterElement(new int[]{1,3,5,2,4},new int[]{6,5,4,3,2,1,7})));

    }
    /**
     * O(n^2)的方法很简单，忽略掉。
     *
     * 我们使用堆栈来保持递减的子序列，每当我们看到大于 stack.peek() 的数字 x 时，我们弹出所有小于 x 的元素并弹出所有元素
     * 这些被弹出来的元素右侧最大的元素即为当前元素
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        // 指向右侧大于当前元素的值，
        Map<Integer,Integer> rightGreaterElement = new HashMap<>();
        if (nums1 == null || nums1.length == 0){
            return new int[]{};
        }
        int[] result = new int[nums1.length];
        for (int num : nums2){
            while (!stack.isEmpty() && stack.peek() < num){
                rightGreaterElement.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length;i ++){
            result[i] = (rightGreaterElement.getOrDefault(nums1[i],-1));
        }
        return result;
    }
}
