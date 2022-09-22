package personal.walker.union.find;

import personal.walker.Solution;

public class LC1319 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections){
            uf.connect(connection[0],connection[1]);
        }
        return uf.extra >=  uf.groupCount - 1 ?  uf.groupCount - 1 : -1;
    }



    private class UnionFind {
        int[] parent;
        int extra; // 多余的cable
        int groupCount;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            groupCount = n;
        }

        void connect(int a,int b){
            int aRoot = findRoot(a);
            int bRoot = findRoot(b);
            if (aRoot == bRoot){
                extra++;
                return;
            }
            if (aRoot > bRoot){
                parent[aRoot] = bRoot;
            }else {
                parent[bRoot] = aRoot;
            }
            groupCount--;
        }

        int findRoot(int x){
            int root = x;
            while (parent[root] != root){
                root = parent[root];
            }
            // 压缩
            parent[x] = root;
            return root;
        }
    }
}
