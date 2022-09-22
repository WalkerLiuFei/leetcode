package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC6113 implements Solution {
    @Override
    public void runTestCases() {}


    class SmallestInfiniteSet {
        int[] integerSet;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        public SmallestInfiniteSet() {
            integerSet = new int[1001];
            priorityQueue = new PriorityQueue<>();

            for (int index = integerSet.length - 1;index > 0; index--){
                priorityQueue.add(index);
                integerSet[index] = 1;
            }
        }

        public int popSmallest() {
            int num = priorityQueue.poll();
            integerSet[num] = 0;
            return num;
        }

        public void addBack(int num) {
            if (integerSet[num] == 1){
                return;
            }
            integerSet[num] = 1;
            priorityQueue.add(num);
        }
    }


}

