package personal.walker.array;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.*;

public class LC347 implements Solution {
    @Override
    public void runTestCases() {
        Gson gson = new Gson();

       int[] result = topKFrequent(new int[]{1,1,1,2,2,3},2);
        System.out.println(gson.toJson(result));


         result = topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
        System.out.println(gson.toJson(result));
    }



    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapper = new HashMap<>();
        //  Arrays.stream(nums).collect(Collectors.toMap( k -> ));
        for (int num : nums) {
            mapper.putIfAbsent(num, 0);
            mapper.put(num, mapper.get(num) + 1);
        }
        Map<Integer, Set<Integer>> buckets = new HashMap<>();
        for (Integer num : mapper.keySet()) {
            buckets.putIfAbsent(mapper.get(num), new HashSet<>());
            buckets.get(mapper.get(num)).add(num);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.addAll(buckets.keySet());
        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty() && result.size() < k){
            result.addAll(buckets.get(priorityQueue.poll()));
        }
        return result.stream().mapToInt(i ->i).toArray();
    }
}
