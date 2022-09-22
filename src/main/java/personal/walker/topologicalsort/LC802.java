package personal.walker.topologicalsort;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC802 implements Solution {
    @Override
    public void runTestCases() {

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length;i++){
            if (topologicalSortWithDfs(graph,i,visited)){
                result.add(i);
            }
        }
        return result;
    }
    boolean topologicalSortWithDfs(int[][] graph,int current,int[] visited){
        // visiting 说明有环，置为NOT_SAFE，return false
        int VISITING = 1;
        int VISITED_SAFE = 2;
        int VISITED_NOT_SAFE = 3;
        if (visited[current] != 0){
            if (visited[current] == VISITED_SAFE){
                return true;
            }
            if (visited[current] == VISITING || visited[current] == VISITED_NOT_SAFE){
                return false;
            }
        }
        visited[current] = VISITING;
        boolean result = true;
        for (int next : graph[current]){
            result = topologicalSortWithDfs(graph,next,visited);
            if (!result){
                break;
            }
        }
        visited[current] = result ? VISITED_SAFE : VISITED_NOT_SAFE;
        return  result;
    }
}
