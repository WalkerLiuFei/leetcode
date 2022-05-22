package personal.walker.dfs;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC1192 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(criticalConnections(4, Util.convertTwoDimensionToIntegerList("[[0,1],[1,2],[2,0],[1,3]]")));
        System.out.println(criticalConnections(6, Util.convertTwoDimensionToIntegerList("[[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]")));
    }


    class Tarjan {
        static final int UNVISITED = -1;
        // current visiting
        Stack<Integer> stack;
        // 是否在栈中
        boolean[] onStack;
        // strong connected components.
        List<List<Integer>> SccS;
        //
        int SccSCount = 0;
        int id; //
        int[] ids;
        Set<Integer> visited;
        int[] lows;
        Map<Integer, List<Integer>> connections;

        Tarjan(int n, Map<Integer, List<Integer>> _connections) {
            stack = new Stack<>();
            onStack = new boolean[n];
            SccS = new ArrayList<>();
            ids = new int[n];
            lows = new int[n];
            this.connections = _connections;
            // unvisited
            Arrays.fill(ids, -1);
            visited = new HashSet<>();
        }

        public boolean isBridge(int a,int b){
            return lows[a] != lows[b];
        }
        public void doCountSccsCount() {
            for (Integer value : connections.keySet()) {
                dfs(value);
            }
        }
        boolean isVisited(int a,int b){
            if (a > b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            return visited.contains(a * 31 + b);
        }
        void setVisited(int a,int b){
            if (a > b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            visited.add(a * 31 + b);
        }
        public void dfs(Integer at) {
            // visited
            stack.add(at);
            onStack[at] = true;
            ids[at] = lows[at] = id++;


            for (Integer neighbor : connections.get(at)) {
                if (isVisited(at,neighbor) || ids[at] >= 0){
                    continue;
                }
                setVisited(at,neighbor);
                dfs(neighbor);
                // 如果neighbor 在 stack 中，取最小的值
                if (onStack[neighbor]) lows[at] = Math.min(lows[at], lows[neighbor]);
            }
            // 已经找到强连通分量中最小的 node，清空stack
            if (ids[at] == lows[at]) {
                for (int node = stack.pop(); ; node = stack.pop()) {
                    onStack[node] = false;
                    // 一个node有可能归属多个强连通分量，所以在弹出栈以后要进行归位
                    lows[node] = lows[at];
                    if (node == at) break;
                }
                SccSCount++;
            }
        }
    }


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> pointMap = new HashMap<>();
        for (List<Integer> integerList : connections) {
            List<Integer> neighbors = pointMap.getOrDefault(integerList.get(0), new ArrayList<>());
            neighbors.add(integerList.get(1));
            pointMap.put(integerList.get(0), neighbors);

            neighbors = pointMap.getOrDefault(integerList.get(1), new ArrayList<>());
            neighbors.add(integerList.get(0));
            pointMap.put(integerList.get(1), neighbors);
        }
        Tarjan tarjan = new Tarjan(n,pointMap);
        tarjan.doCountSccsCount();
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> integerList : connections) {
            if (tarjan.isBridge(integerList.get(0),integerList.get(1))){
                result.add(integerList);
            }
        }
        System.out.println(tarjan.SccSCount);
        return result;

    }


}
