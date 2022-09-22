package personal.walker.heap.priority.queue;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC53 implements Solution {
    @Override
    public void runTestCases() {

    }
  // [1,6],[4,5],[6,]
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        // 最大的在堆顶，这样来一个新值只要最大未被覆盖，就不需要合并
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int[] interval : intervals){
            int[] top = pq.peek();
            if (top == null || interval[0] > top[1]){
                pq.add(interval);
                continue;
            }
            pq.poll();
            top[1] = Math.max(top[1],interval[1]);
            pq.add(top);
        }

        return pq.toArray(new int[][]{});
    }
}
