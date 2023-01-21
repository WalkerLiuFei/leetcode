package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC6226 implements Solution {
    @Override
    public void runTestCases() {
        destroyTargets(new int[]{1,5,3,2,2},10000);
    }

    class Info {
        int divide;
        int modResult;

        int index;

        int count;

        public Info(int divide, int modResult, int index) {
            this.divide = divide;
            this.modResult = modResult;
            this.index = index;
        }

    }

    public int destroyTargets(int[] nums, int space) {
        Arrays.sort(nums);
        int[] modResults = new int[nums.length];


        HashMap<Integer, Integer> map = new HashMap<>();
        int result = nums[0];
        int maxNum = 1;
        int maxModResult = result % space;
        //HashMap<Integer, PriorityQueue<Info>> pqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int modResult = nums[i] % space;
            map.putIfAbsent(modResult,1);
            map.put(modResult,map.get(modResult) + 1);
            if (map.get(modResult) > maxNum){
                 maxNum = map.get(modResult);
                 maxModResult = modResult;
            }
            modResults[i] = modResult;
        }

        for (int i = 0; i < modResults.length; i ++){
            if (map.get(modResults[i]) == maxNum){
                return nums[i];
            }
        }
        return nums[0];
    }
}
