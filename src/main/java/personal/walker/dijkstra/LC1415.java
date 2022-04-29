package personal.walker.dijkstra;

import personal.walker.Solution;

import java.util.*;

public class LC1415 implements Solution {
    @Override
    public void runTestCases() {
      //  maxProbability(5,new int[][]{[[1,4],[2,4],[0,4],[0,3],[0,2],[2,3]]},)
    }

    class Node {
        int val;
        List<Integer> neighbors;
        List<Double> probabilities;
        double startProbability = 0;
        Node(Integer val) {
            this.val = val;
            neighbors = new ArrayList<>();
            probabilities = new ArrayList<>();
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        // 建图
        for (int i = 0; i < edges.length; i++) {
            nodeMap.putIfAbsent(edges[i][0], new Node(edges[i][0]));
            nodeMap.putIfAbsent(edges[i][1], new Node(edges[i][1]));
            nodeMap.get(edges[i][0]).neighbors.add(edges[i][1]);
            nodeMap.get(edges[i][1]).neighbors.add(edges[i][0]);
            nodeMap.get(edges[i][0]).probabilities.add(succProb[i]);
            nodeMap.get(edges[i][1]).probabilities.add(succProb[i]);

        }
        // bfs
         // use dfs will TLE
        //dfs(nodeMap,start,maxProbabilities,end,1);
        //USE bfs
        nodeMap.get(start).startProbability = 1;
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(nodeMap.get(start).val);
        while (!nodeQueue.isEmpty()){
           Node node = nodeMap.get(nodeQueue.poll());
           if (node != null && node.neighbors != null){
               for (int index = 0; index < node.neighbors.size();index++){
                  Node neighborNode = nodeMap.get(node.neighbors.get(index));
                  if (neighborNode.startProbability < node.startProbability * node.probabilities.get(index)){
                      neighborNode.startProbability =  node.startProbability * node.probabilities.get(index);
                      nodeQueue.add(neighborNode.val);
                  }
               }
           }
        }
        return nodeMap.get(end) == null ? 0 : nodeMap.get(end).startProbability;
    }

    private void dfs(Map<Integer, Node> nodeMap,int node ,double[] visited,  int end,double probability){
        if (node == end){
            return;
        }
        if (nodeMap.get(node) == null || nodeMap.get(node).neighbors == null){
            return;
        }
        for (int i = 0; i < nodeMap.get(node).neighbors.size();i++){
            if (visited[nodeMap.get(node).neighbors.get(i)] < probability * nodeMap.get(node).probabilities.get(i)){
                visited[nodeMap.get(node).neighbors.get(i)] = probability * nodeMap.get(node).probabilities.get(i);
                dfs(nodeMap,nodeMap.get(node).neighbors.get(i),visited,end,visited[nodeMap.get(node).neighbors.get(i)]);
            }
        }
    }
}
