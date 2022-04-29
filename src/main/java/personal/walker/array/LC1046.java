package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1046 implements Solution {
    @Override
    public void runTestCases() {
    }

    public int lastStoneWeight(int[] stones) {
        // 大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int stone : stones){
            priorityQueue.add(stone);
        }

        while (priorityQueue.size() > 1){
            int  a = priorityQueue.poll();
            int b = priorityQueue.poll();
            if (a != b){
                priorityQueue.add(a-b);
            }
        }
        if (priorityQueue.isEmpty()){
            return 0;
        }
        return priorityQueue.poll();
    }
}
