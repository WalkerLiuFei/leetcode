package personal.walker.contest;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC6231 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(totalCost(new int[]{17,12,10,2,7,2,11,20,8},3,4));
        System.out.println(totalCost(new int[]{17,12,10,9},3,4));
        System.out.println(totalCost(new int[]{1,2,4,1},3,3));
    }


    public long totalCost(int[] costs, int k, int candidates) {
      //  List<Integer> first = new ArrayList<>();
        PriorityQueue<Integer> first = new PriorityQueue<>();
        PriorityQueue<Integer> last = new PriorityQueue<>();
        int firstBound = 0;

        while (true){
            first.add(costs[firstBound]);
            if (first.size() == candidates || firstBound == costs.length - 1){
                break;
            }
            firstBound ++;
        }
        int lastBound = costs.length - 1;
        while (lastBound > firstBound ){
            last.add(costs[lastBound]);
            if (last.size() == candidates ){
                break;
            }
            lastBound --;
        }

        long result = 0;
        while (k > 0){
            if ((first.size() > 0 && last.size() > 0 && first.peek() > last.peek()) || (first.size() == 0 && last.size() > 0)){
                result += last.poll();
                if (lastBound > firstBound + 1){
                    lastBound--;
                    last.add(costs[lastBound]);
                }
            }else if ((first.size() > 0 && last.size() > 0 && first.peek() <= last.peek()) || (first.size() > 0 && last.size() == 0)){
                result += first.poll();
                if (firstBound < lastBound - 1){
                    firstBound++;
                    first.add(costs[firstBound]);
                }
            }
            k--;
        }
        return result;
    }

}
