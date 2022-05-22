package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.Stack;

public class LC581 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1,2,3,4}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
        System.out.println(findUnsortedSubarray(new int[]{1,2}));
        System.out.println(findUnsortedSubarray(new int[]{1,2,3}));
        System.out.println(findUnsortedSubarray(new int[]{1,3,2}));
        System.out.println(findUnsortedSubarray(new int[]{4,3,2,1}));
        System.out.println(findUnsortedSubarray(new int[]{2,1}));
        System.out.println(findUnsortedSubarray(new int[]{1,2,3,3,3}));
        System.out.println(findUnsortedSubarray(new int[]{1,2,3,3,3}));

    }

    /**
     * 维护一个最小队列，队首为最小元素
     * 双指针，找有序的，维护一个单调栈、
     * [2,6,4,8,10,9,15]
     * <p>
     * 直接排序，然后将中间不相等的元素对其相加就是结果。。
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int start = -1, end = -1, min =-1, max = -1;
        for (int index = 1; index < nums.length; index++ ){
            if (nums[index] < nums[index-1] && start == -1 ){
                start = index;
                min = nums[index];
            }
            if (min > nums[index] ){
                min = nums[index];
            }
        }
        if (start == -1) {
            return 0;
        }
        for (int index = 0; index < nums.length; index++){
            if (min < nums[index]){
                start = index;
                break;
            }
        }

        for (int index = nums.length - 2; index >= 0; index-- ){
            if (nums[index] > nums[index+1] && end == -1) {
                end = index;
                max = nums[index];
            }
            if (max < nums[index]) {
                max = nums[index];
            }
        }
        for (int index =nums.length - 1; index >= 0; index--) {
            if (max > nums[index]) {
                end = index;
                break;
            }
        }
        return end - start + 1;
    }
}
