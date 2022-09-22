package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC2344 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(minOperations(new int[]{3,2,6,2,35,5,35,2,5,8,7,3,4},new int[]{105,70,70,175,105,105,105}));
        System.out.println(minOperations(new int[]{16,6,6,9,12,12,7,12},new int[]{174740464,864178736}));

    }

    public int minOperations(int[] nums, int[] numsDivide) {
        int min = numsDivide[0];
        for (int num : numsDivide) {
            if (min > num) {
                min = num;
            }
        }
        PriorityQueue<Integer> candidates = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        //int smallest = 1 << 31 - 1;
        for (int num : nums) {
            if (min % num == 0 ) {
                candidates.add(num);
            }
        }

        int result = 0;
        int resultNum = -1;
        while (candidates.size() != 0){
            int num = candidates.poll();
            boolean flag = true;
            for (int divide : numsDivide){
                if (divide % num != 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                resultNum = num;
                break;
            }
        }
        if (resultNum == -1){
            return  -1;
        }
        for (int num : nums){
            if (num < resultNum){
                result++;
            }
        }
        return  result;
    }
}
