package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.ListNode;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC6139 implements Solution {
    @Override
    public void runTestCases() {
        // System.out.println(reachableNodes(10, Util.convertTwoDimensionToIntegerArray("[[8,2],[2,5],[5,0],[2,7],[1,7],[3,8],[0,4],[3,9],[1,6]]"), new int[]{9, 8, 4, 5, 3, 1}));
        System.out.println(reachableNodes(7, Util.convertTwoDimensionToIntegerArray("[[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]]"), new int[]{4, 2, 1}));

    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrictedSet = new HashSet<>();
        for (int a : restricted) {
            restrictedSet.add(a);
        }
        List<List<Integer>> mapper = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mapper.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            if (restrictedSet.contains(edge[0]) || restrictedSet.contains(edge[1])) {
                continue;
            }
            mapper.get(edge[0]).add(edge[1]);
            mapper.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];

        dfs(mapper, visited, 0);
        return result;
    }

    int result = 0;

    public void dfs(List<List<Integer>> mapper, boolean[] visited, int node) {
        if (visited[node]) {
            return;
        }
        result++;
         visited[node] = true;
         for (Integer nextNode : mapper.get(node)) {
            dfs(mapper, visited, nextNode);
        }
    }
}