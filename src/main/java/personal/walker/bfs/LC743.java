package personal.walker.bfs;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC743 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(networkDelayTime(Util.convertTwoDimensionToIntegerArray("[[2,1,1],[2,3,1],[3,4,1]]"),4,2));
        System.out.println(networkDelayTime(Util.convertTwoDimensionToIntegerArray("[[1,2,1]]"),2,1));
        System.out.println(networkDelayTime(Util.convertTwoDimensionToIntegerArray("[[1,2,1]]"),2,2));
        System.out.println(networkDelayTime(Util.convertTwoDimensionToIntegerArray("[[1,2,1],[2,3,2]]"),3,1));
    }

    class Node {
         // minimum time to receive the signal.
        int timeSpent;
        // value 2 times
        Map<Integer,Integer> neighbors;
        public void addNeighbor(Integer neighbor,Integer time){
            neighbors.put(neighbor,time);
        }

        public void setTimeSpent(Integer _minimumTime){
            this.timeSpent = _minimumTime;
        }
        public int getTimeSpent(){
           return timeSpent;
        }
        Node(){
            neighbors = new HashMap<>();
            timeSpent = Integer.MAX_VALUE >> 1;
         }
    }
    /**
     * 简单的Dijkstra  算法，利用bfs寻找最短路径、
     * 1. 建图 ：
     * 2. 搜索
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        Node[] nodes = new Node[n + 1];
        Gson gson = new Gson();
        for (int index = 1; index <= n; index ++){
            nodes[index] = new Node();
        }

        for (int[] time : times){
            Node node =  nodes[time[0]];
            node.addNeighbor(time[1],time[2]);
//
//            node = nodes[time[1]];
//            node.addNeighbor(time[0],time[2]);
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        Node node = nodes[k];
        if (node == null){
            return  -1;
        }
        node.setTimeSpent(0);
        nodeQueue.add(node);
        int levelNum = 1;

        while (!nodeQueue.isEmpty()){
            int newLevelNum = 0;
            while (levelNum-- > 0){
                node = nodeQueue.poll();
                for (Map.Entry<Integer,Integer> neighbor : node.neighbors.entrySet()){
                    Node neighborNode = nodes[neighbor.getKey()];
                    // 没有相邻的点
                    Integer timeToNeighbor = neighbor.getValue();
                    if (timeToNeighbor + node.getTimeSpent() <  neighborNode.getTimeSpent()){
                        neighborNode.setTimeSpent(timeToNeighbor + node.getTimeSpent());
                        nodeQueue.add(neighborNode);
                        newLevelNum++;
                    }
                }
            }
            levelNum = newLevelNum;
        }
        System.out.println(gson.toJson(nodes));
        int ans = -1;
        for (int index = 1; index <= n ; index++){
            if (nodes[index].timeSpent == Integer.MAX_VALUE >> 1){
                return -1;
            }
            ans = Math.max(nodes[index].timeSpent,ans);
        }
        return ans;
    }
}
