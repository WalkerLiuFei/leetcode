package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC6106 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(countPairs(7, Util.convertTwoDimensionToIntegerArray("[[0,2],[0,5],[2,4],[1,6],[5,4]]")));
    }
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges){
            uf.union(edge[0],edge[1]);
        }
        long result = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < n ; i++){
            Integer v = countMap.get(uf.find(i));
            if (v == null){
                countMap.put(uf.find(i),1);
                continue;
            }
            countMap.put(uf.find(i),v +1);
        }

        int[] values = new int[countMap.size()];
        int i =0;
        for (Integer v : countMap.values()){
            values[i++] = v;
        }
        int[] preSum = new int[values.length];

        preSum[0] = values[0];
        for (i = 1; i < values.length;i++){
            preSum[i] = preSum[i-1] + values[i];
        }

        for (i = values.length - 1; i > 0;i--){
            result += (long)values[i] * preSum[i - 1];
        }
        return result;
    }

    class UnionFind {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的“重量”
        private int[] size;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }

    }

}
