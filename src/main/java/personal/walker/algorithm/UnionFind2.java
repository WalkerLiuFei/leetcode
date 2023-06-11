package personal.walker.algorithm;

import java.util.*;

public class UnionFind2 {


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
                int edgesCount = dfs(i, -1, graph);
                if (edgesCount == nodes * (nodes - 1))
                    fullyConnected++;
            }
        }

        return fullyConnected;
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> graph) {

        int edgesCount = 0;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (neighbor != parent) {
                    edgesCount += 1 + dfs(neighbor, node, graph);
                }
            }
        }
        return edgesCount;
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
