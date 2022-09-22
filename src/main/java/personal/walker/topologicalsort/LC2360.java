package personal.walker.topologicalsort;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC2360 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(longestCycle(new int[]{ 3,3,4,2,3}));
    }



    /**
     * 1. 使用dfs to found a cycle, and the cycle's entry point, than get the cycle's length
     */
    int[] cycleLength;
    public int longestCycle(int[] edges) {
        cycleLength = new int[edges.length];
        int[] visited = new int[edges.length];
        int result = -1;
        int[] sequence = new int[edges.length];
        for (int i = 0; i < edges.length;i ++){
            if (edges[i] < 0 || visited[i] > 0){
                continue;
            }
            result = Math.max(dfs(edges,i,visited,1,sequence),result);
        }
        return result;
    }



    int dfs(int[] edges,int current,int[] visit,int currentLength,int[] sequence){
        int VISITING = 1;
        int VISITED = 2;
        if (current == -1){
            return -1;
        }
        if (visit[current] == VISITED){
            return cycleLength[current];
        }
        // find a cycle.
        if (visit[current] == VISITING){
            return currentLength - sequence[current];
        }

        sequence[current] = currentLength;
        visit[current] = VISITING;
        int length = dfs(edges,edges[current],visit,currentLength+ 1,sequence);
        visit[current] = VISITED;
        cycleLength[current] = length;
        return cycleLength[current];
    }
}
