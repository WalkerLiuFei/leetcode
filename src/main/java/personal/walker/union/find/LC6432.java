package personal.walker.union.find;

import personal.walker.Main;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC6432 implements Solution {
    @Override
    public void runTestCases() {
        // System.out.println(countCompleteComponents(6, Util.convertTwoDimensionToIntegerArray("[[0,1],[0,2],[1,2],[3,4]]")));
        System.out.println(countCompleteComponents(3, Util.convertTwoDimensionToIntegerArray("[[1,0],[2,0]]")));

    }


    private int[] parent;
    private int[] rank;
    private int[] count;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        count = new int[n];

        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++) parent[i] = i;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int fullyConnected = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) {
                int nodes = count[i];
                boolean[] visit = new boolean[n];
                int edgesCount = dfs(i, graph, 0, visit);
                if (edgesCount == nodes)
                    fullyConnected++;
            }
        }

        return fullyConnected;
    }

    private int dfs(int node, Map<Integer, List<Integer>> graph, int current, boolean[] visit) {

        if (visit[node]) {
            return current;
        }
        visit[node] = true;
         int newCurrent = current;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                newCurrent = Math.max(newCurrent, dfs(neighbor, graph, current + 1, visit));
            }
        }
        return newCurrent;
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                count[rootX] += count[rootY];
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                count[rootY] += count[rootX];
            } else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
                count[rootX] += count[rootY];
            }
        }
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }


}
