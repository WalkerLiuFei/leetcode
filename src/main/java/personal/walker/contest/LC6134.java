package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC6134 implements Solution {
    @Override
    public void runTestCases() {
        //System.out.println(closestMeetingNode(new int[]{2,2,3,-1},0,1));
        System.out.println(closestMeetingNode(new int[]{4,4,8,-1,9,8,4,4,1,1},5,6));  // 1
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer, Integer> node1Map = reachMap(edges, node1);
        HashMap<Integer, Integer> node2Map = reachMap(edges, node2);
        int maxDistance = 1 << 31 - 1;
        int resultIndex = -1;
        for (Map.Entry<Integer, Integer> entry : node1Map.entrySet()) {
            if (node2Map.containsKey(entry.getKey()) && maxDistance > Math.max(entry.getValue(),node2Map.get(entry.getKey()))) {
                maxDistance =  (Math.max(entry.getValue(),node2Map.get(entry.getKey())));
                resultIndex = entry.getKey();
            }
        }
        return resultIndex;
    }

    public HashMap<Integer, Integer> reachMap(int[] edges, int node) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        queue.add(edges[node]);

        result.put(node, 0);
        int level = 1;
        int levelCount = 1;
        if (edges[node] == -1){
            return result;
        }
        result.put(edges[node], level);
        while (!queue.isEmpty()) {
            int newLevelCount = 0;
            while (levelCount > 0) {
                node = queue.poll();
                if (edges[node] != -1 && !result.containsKey(edges[node])) {
                    queue.add(edges[node]);
                    newLevelCount++;
                }
                result.put(node, level);
                levelCount--;
            }
            level++;
            levelCount = newLevelCount;
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
        return result   ;
    }
}
