package personal.walker.contest;

import personal.walker.Main;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC6255 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(
                minScore(4, Util.convertTwoDimensionToIntegerArray("[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]"))
        );
        System.out.println(
                minScore(3, Util.convertTwoDimensionToIntegerArray("[[3,2,1],[1,3,3]]"))
        );
    }


    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> roaMap = new HashMap<>();
        for (int[] rd : roads) {
            roaMap.putIfAbsent(rd[0], new ArrayList<>());
            roaMap.get(rd[0]).add(new int[]{rd[1], rd[2]});

            roaMap.putIfAbsent(rd[1], new ArrayList<>());
            roaMap.get(rd[1]).add(new int[]{rd[0], rd[2]});
        }
        return dfs(roaMap, n, 1, new int[n + 1], Integer.MAX_VALUE);
    }

    public int dfs(Map<Integer, List<int[]>> graph, int targetNode, int currentNode, int[] visited, int currentSmallest) {
        if (visited[currentNode] >= 2) {
            return currentSmallest;
        }
        visited[currentNode]++;
        for (int[] next : graph.get(currentNode)) {
            int tmpSmallest = next[1];
            tmpSmallest = Math.min(tmpSmallest, dfs(graph, targetNode, next[0], visited, currentSmallest));
            currentSmallest = Math.min(currentSmallest, tmpSmallest);
        }
        return currentSmallest;
    }
}
