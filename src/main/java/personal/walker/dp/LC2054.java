package personal.walker.dp;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC2054 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {2, 4, 3}}));

        System.out.println(maxTwoEvents(Util.convertTwoDimensionToIntegerArray("[[10,83,53],[63,87,45],[97,100,32],[51,61,16]]")));
        ;
    }

    /**
     * 两次轮训第一次,dp[]
     *
     * @return
     */
    class Event {
        int startTime;
        int endTime;
        int value;

        public Event(int startTime, int endTime, int value) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.value = value;
        }
    }

    /**
     * dp[start][end] = dp[start][end] + dp[0][start] +
     *
     * @param events
     * @return
     */
    public int maxTwoEvents(int[][] events) {
        List<Event> eventList = new ArrayList<>();
        for (int[] event : events) {
            eventList.add(new Event(event[0] - 1, event[1], event[2]));
        }
        eventList.sort(Comparator.comparingInt(o -> o.endTime));
        int result = 0;
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (Event event : eventList) {
            Integer exist = valueMap.getOrDefault(event.endTime, 0);
            valueMap.put(event.endTime, Math.max(valueMap.getOrDefault(event.startTime, 0) + event.value, exist));
            System.out.printf("endTime %d, event value is %s\n", event.endTime, valueMap.get(event.endTime));
            result = Math.max(valueMap.getOrDefault(event.endTime, 0), result);
        }
        return result;
    }
}
