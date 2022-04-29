package personal.walker.heap.priority.queue;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC295_UNSOLVED implements Solution {
    @Override
    public void runTestCases() {

    }

    class MedianFinder {
        PriorityQueue<Integer> priorityQueue;
        public MedianFinder() {
            priorityQueue = new PriorityQueue<>(Integer::compareTo);
        }

        public void addNum(int num) {
            priorityQueue.add(num);
        }

        public double findMedian() {
            Integer[] array = priorityQueue.toArray(new Integer[]{});
            if (priorityQueue.size() %2 == 1){
                return array[priorityQueue.size() / 2];
            }
            return (array[priorityQueue.size() / 2 - 1] + array[priorityQueue.size() / 2 - 1]) / 2.0;
        }
    }

    // TLE
    class MedianFinder_BrutualForce {
        List<Integer> storage;
        public MedianFinder_BrutualForce() {
            storage = new ArrayList<>();
        }

        public void addNum(int num) {
            storage.add(num);
            storage.sort(Integer::compareTo);
        }

        public double findMedian() {
            if (storage.size() %2 == 1){
                return storage.get(storage.size() / 2);
            }
            return (storage.get(storage.size() / 2 - 1) + storage.get(storage.size() / 2 )) / 2.0;
        }
    }
}
