package personal.walker.stack;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/
public class LC503 implements Solution {
    @Override
    public void runTestCases() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(nextGreaterElements(new int[]{1,2,1})));

        System.out.println(gson.toJson(nextGreaterElements(new int[]{4,2,5})));
        System.out.println(gson.toJson(nextGreaterElements(new int[]{1,3,5,2,4})));
        System.out.println(gson.toJson(nextGreaterElements(new int[]{5,5,5,5,5,6})));
        System.out.println(gson.toJson(nextGreaterElements(new int[]{5,5,5,5,5,1})));
        System.out.println(gson.toJson(nextGreaterElements(new int[]{100,1,11,1,120,111,123,1,-1,-100})));
    }
    /**
     * LC 496的简单变种，一样用单调栈来找。不同的是我们需要扫两边。
     * 第二遍再扫的时候，如果第一遍有值了，忽略掉即可。
     *
     * */

    //对 nextGreaterElements_1 的优化，避开 map操作直接使用结果数组更快
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        // 指向右侧大于当前元素的值，
         if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        for (int i = 0; i < nums.length;i ++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                //rightGreaterElement.put(stack.pop(),nums[i]);
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length;i ++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                if (result[index] != -1){
                    continue;
                }
                result[index] = nums[i];
            }
            stack.push(i);
        }
//        for (int i = 0; i < nums.length;i ++){
//            result[i] = (rightGreaterElement.getOrDefault(i,-1));
//        }
        return result;
    }


    public int[] nextGreaterElements_1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        // 指向右侧大于当前元素的值，
        Map<Integer,Integer> rightGreaterElement = new HashMap<>();
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length;i ++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                rightGreaterElement.put(stack.pop(),nums[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length;i ++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                Integer index = stack.pop();
                if (rightGreaterElement.get(index) != null){
                    continue;
                }
                rightGreaterElement.put(index,nums[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length;i ++){
            result[i] = (rightGreaterElement.getOrDefault(i,-1));
        }
        return result;
    }


}
