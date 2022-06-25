package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 讲解 ： https://zxi.mytechroad.com/blog/heap/leetcode-239-sliding-window-maximum/
 * 单调队列 ： https://www.jianshu.com/p/e59d51e1eef5
 */
public class LC239 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * 使用 单调队列递减的单调队列，保证队列中的元素严格递减(>). **另外，因为会有重复元素出现，所以要保证队列中存储的应该是原数组的下标**
     *
     * 1. 保证队首的元素最大
     * 2. 新值要小于队尾部，如果大于队尾，则清除队尾直到队列有序递减
     *
     * 1,3,-1,-3,5,4,6,7   1
     * 1,3,-1,-3,5,4,6,7   3
     * 1,3,-1,-3,5,4,6,7   3,-1
     * 1,3,-1,-3,5,4,6,7   3,-1,-3
     * 1,3,-1,-3,5,4,6,7   5
     * 1,3,-1,-3,5,4,6,7   5,4
     * 1,3,-1,-3,5,4,6,7   6
     * 1,3,-1,-3,5,4,6,7   7
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        return null;
    }

}
