package personal.walker.dp;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class LC1235 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(jobScheduling(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));
        System.out.println(jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
    }

    class Job {
        int startTime;
        int endTime;
        int profit;

        Job(int startTime,
            int endTime,
            int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }


    public int jobScheduling(int[] startTimeArray, int[] endTimeArray, int[] profitArray) {
        Job[] jobs = new Job[startTimeArray.length];
        for (int i = 0; i < startTimeArray.length; i++) {
            jobs[i] = new Job(startTimeArray[i], endTimeArray[i], profitArray[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(o -> o.endTime));
        int result = 0;
        HashMap<Integer, Integer> dpProfit = new HashMap<>();
        for (int i = 0; i < startTimeArray.length; i++) {
            dpProfit.put(startTimeArray[i], 0);
        }
        for (int i = 0; i < jobs.length; i++) {
            int startTime = jobs[i].startTime;
            int endTime = jobs[i].endTime;
            int profit = jobs[i].profit;

            int temp = dpProfit.getOrDefault(startTime, 0) + profit;
            if (i > 0) {
                temp = Math.max(temp, dpProfit.getOrDefault(jobs[i - 1].endTime, 0));
            }
            dpProfit.put(endTime, temp);
            result = Math.max(temp, result);
            System.out.println(dpProfit);
        }
        return result;
    }

}
