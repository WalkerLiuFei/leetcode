package personal.walker.dfs;

import personal.walker.Solution;

import java.util.*;

public class LC2192 implements Solution {

    @Override
    public void runTestCases() {

    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // 一级指向
        List<List<Integer>> level1Point = new ArrayList(10);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0;i < n;i ++){
            level1Point.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            level1Point.get(edge[1]).add(edge[0]);
        }
        for (int i = 0;i < n;i++){
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            Set<Integer> set = new HashSet<>();
            dfs(level1Point,i,set,visited);
            result.get(i).addAll(set);
        }
        for (List<Integer> integers : result) {
            Collections.sort(integers);
        }
        return result;
    }
    // return all ancestors
    public void dfs(List<List<Integer>> level1Point, int index, Set<Integer> set, boolean[] visited) {
        if (visited[index]){
            return ;
        }
        visited[index] = true;
        set.addAll(level1Point.get(index));
        for (Integer i : level1Point.get(index)){
            dfs(level1Point,i,set,visited);
        }
    }
}
