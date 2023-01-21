package personal.walker.contest;

import personal.walker.Solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC6285 implements Solution {
    @Override
    public void runTestCases() {

    }


    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums){
            pq.add(num);
        }
        long result = 0;
        while (k > 0){
            int num = pq.poll();
            result += num;
            if (num % 3 == 0){
                num /= 3;
            }else {
                num /= 3;
                num++;
            }
            pq.add(num);
            k--;
        }
        return result;
    }
}
