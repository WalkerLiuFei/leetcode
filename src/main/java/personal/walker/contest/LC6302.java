package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6302 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println((maxScore(new int[]{22, 5, 25, 15, 28, 1}, new int[]{22, 30, 25, 25, 9, 18}, 3))); // 1364
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        return Math.max(helper1(nums1, nums2, k), helper2(nums1, nums2, k));
    }

    public long helper1(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>();
        HashMap<Integer,Integer> nums2Map = new HashMap<>();
        long num1Sum = 0;
        for (int i = 0; i < k; i++) {
            minHeap.add(new int[]{nums2[i], nums1[i], i});
            num1Sum += nums1[i];
            nums2Map.putIfAbsent(nums2[i],0);
            nums2Map.put(nums2[i],nums2Map.get(nums2[i]) + 1);
            minHeap2.add(nums2[i]);
        }

        if (minHeap.size() == 0) {
            return 0;
        }
        int i = k;
        long result = num1Sum * minHeap2.peek();
        while (i < nums1.length && minHeap.size() > 0) {
            int[] top = minHeap.poll();
            nums2Map.put(top[0],nums2Map.get(top[0])- 1);
            minHeap.add(new int[]{nums2[i], nums1[i], i});
            num1Sum -= top[1];
            num1Sum += nums1[i];

            while (minHeap2.size() > 0 && (!nums2Map.containsKey(minHeap2.peek()) || nums2Map.get(minHeap2.peek()) == 0)){
                minHeap2.poll();
            }
            nums2Map.putIfAbsent(nums2[i],0);
            nums2Map.put(nums2[i],nums2Map.get(nums2[i]) + 1);
            minHeap2.add(nums2[i]);
            result = Math.max(num1Sum * minHeap2.peek(), result);
            i++;
        }
        return result;
    }

    public long helper2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        long num1Sum = 0;

        for (int i = 0; i < k; i++) {
            minHeap.add(new int[]{nums2[i], nums1[i], i});
            num1Sum += nums1[i];
        }

        if (minHeap.size() == 0) {
            return 0;
        }
        int i = k;
        long current = num1Sum * minHeap.peek()[0];
        long result = current;
        while (i < nums1.length && minHeap.size() > 0) {
            int[] top = minHeap.poll();
            minHeap.add(new int[]{nums2[i], nums1[i], i});
            num1Sum -= top[1];
            num1Sum += nums1[i];
            current = num1Sum * minHeap.peek()[0];
            result = Math.max(current, result);
            i++;
        }
        return result;
    }

}
