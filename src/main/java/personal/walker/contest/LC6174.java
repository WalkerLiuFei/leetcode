package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;

public class LC6174 implements Solution {
    @Override
    public void runTestCases() {
       // System.out.println(taskSchedulerII(new int[]{1,2,1,2,3,1},3));
        System.out.println(taskSchedulerII(new int[]{1,1},10));

    }

    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> type2Day = new HashMap<>();
        long days = 1;
        for (int task : tasks) {
            if (type2Day.get(task) != null && days - type2Day.get(task) <= space) {
                days += space - (days - type2Day.get(task)) + 1;
            }
            System.out.printf("task -> %d, day -> %d \n",task,days);
            type2Day.put(task, days++);
        }
        return days - 1;
    }
}
