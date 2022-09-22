package personal.walker.heap.priority.queue;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC2406 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(minGroups(Util.convertTwoDimensionToIntegerArray("[[5,10],[6,8],[1,5],[2,3],[1,10]]")));
        System.out.println(minGroups(Util.convertTwoDimensionToIntegerArray("[[1,3],[5,6],[8,10],[11,13]]")));
        System.out.println(minGroups(Util.convertTwoDimensionToIntegerArray("[[159431,428743],[614908,651142],[431031,806494]]"))); // 2
        System.out.println(minGroups(Util.convertTwoDimensionToIntegerArray("[[351436,933571],[667214,975379],[782454,919174],[231661,764081],[848495,902497],[332817,520328],[740795,762394],[665739,726786],[546865,686588],[360501,846864]]")));
        System.out.println(minGroups(Util.convertTwoDimensionToIntegerArray("[[1,3],[5,6],[8,10],[11,13]]")));
        System.out.println(minGroups(Util.convertTwoDimensionToIntegerArray("[[1,3],[5,6],[8,10],[11,13]]")));

    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] interval : intervals) {
            int[] top = pq.peek();
            if (top == null || top[1] >= interval[0]) {
                pq.add(interval);
                continue;
            }
            pq.poll();
            top[1] = interval[1];
            pq.add(top);
        }
        return pq.size();
    }

    public int minGroups_lte(int[][] intervals) {
        //List<Interval> intervalList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        boolean[] taken = new boolean[intervals.length];
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (taken[i]) {
                continue;
            }
            // int start = intervals[i][0];
            int end = intervals[i][1];
            taken[i] = true;
            // find the next
            int searchIndex = search(intervals, end, i + 1, intervals.length - 1);
            while (searchIndex < intervals.length) {
                if (taken[searchIndex]) {
                    searchIndex++;
                    continue;
                }
                taken[searchIndex] = true;
                end = intervals[searchIndex][1];
                searchIndex = search(intervals, end, searchIndex + 1, intervals.length - 1);
                if (searchIndex == intervals.length - 1) {
                    if (intervals[searchIndex][0] > end) {
                        taken[searchIndex] = true;
                    }
                    break;
                }
            }
            System.out.println(Arrays.toString(taken));
            result++;
        }
        return result;
    }

    // [1,2],[3,4],[]
    public int search(int[][] intervals, int target, int start, int end) {
        while (end > start) {
            int mid = (end - start) / 2 + start;
            if (intervals[mid][0] < target) {
                start = mid + 1;
            } else if (intervals[mid][0] > target) {
                end = mid - 1;
            } else {
                return mid + 1;
            }
        }
        if (intervals[end][0] > target) {
            return end;
        }
        return end + 1;
    }
}
