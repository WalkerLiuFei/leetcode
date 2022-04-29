package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class LC581 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     *  维护一个最小队列，队首为最小元素
     *  双指针，找有序的，维护一个单调栈、
     *  [2,6,4,8,10,9,15]
     *
     *  直接排序，然后将中间不相等的元素对其相加就是结果。。
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        return 0;
    }
}
