package personal.walker.dijktra;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

/**
 * 前往目标的最小代价 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Medium
 * 给你一个数组 start ，其中 start = [startX, startY] 表示你的初始位置位于二维空间上的 (startX, startY) 。另给你一个数组 target ，其中 target = [targetX, targetY] 表示你的目标位置 (targetX, targetY) 。
 * <p>
 * 从位置 (x1, y1) 到空间中任一其他位置 (x2, y2) 的代价是 |x2 - x1| + |y2 - y1| 。
 * <p>
 * 给你一个二维数组 specialRoads ，表示空间中存在的一些特殊路径。其中 specialRoads[i] = [x1i, y1i, x2i, y2i, costi] 表示第 i 条特殊路径可以从 (x1i, y1i) 到 (x2i, y2i) ，但成本等于 costi 。你可以使用每条特殊路径任意次数。
 * <p>
 * 返回从 (startX, startY) 到 (targetX, targetY) 所需的最小代价。
 */
public class LC6343 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(minimumCost(new int[]{1, 1}, new int[]{4, 5}, Util.convertTwoDimensionToIntegerArray("[[1,2,3,3,2],[3,4,4,5,1]]")));
    }

    // 两点之间直线最短
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Graph graph = new Graph(specialRoads.length * 2 + 2);
        Map<Point, Integer> mapID = new HashMap<>();
        //Set<Point> set = new HashSet<>();
        int id = 0;
        mapID.put(new Point(start[0], start[1]), id++);

        mapID.put(new Point(target[0], target[1]), id++);

        for (int[] specialRoad : specialRoads) {
            Point point1 = new Point(specialRoad[0], specialRoad[1]);
            int id1;
            if (mapID.containsKey(point1)) {
                id1 = mapID.get(point1);
            } else {
                id1 = id;
                mapID.put(point1, id++);
            }
            Point point2 = new Point(specialRoad[2], specialRoad[3]);
            int id2;
            if (mapID.containsKey(point2)) {
                id2 = mapID.get(point2);
            } else {
                id2 = id;
                mapID.put(point2, id++);
            }

            graph.addEdgeIfNotExist(id1, id2, specialRoad[4]);
        }
        for (Point point1 : mapID.keySet()) {
            for (Point point2 : mapID.keySet()) {
                int id1 = mapID.get(point1);
                int id2 = mapID.get(point2);
                graph.addEdgeIfNotExist(id1,id2,Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y));
            }
        }

        return dijkstraShortestPath(graph, 0)[1];
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int NOT_CONNECTED = -1;

    public static class Graph {
        private int[][] adjList;

        public Graph(int numVertices) {
            adjList = new int[numVertices][numVertices];
            for (int i = 0; i < adjList.length; i++) {
                Arrays.fill(adjList[i], NOT_CONNECTED);
            }
        }


        public void addEdgeIfNotExist(int src, int dest, int weight) {
            if (adjList[src][dest] != NOT_CONNECTED) {
                return;
            }
            adjList[src][dest] = weight;
        }

    }

    public static class Vertex {
        int id;
        int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public static int[] dijkstraShortestPath(Graph graph, int start) {
        int[] distances = new int[graph.adjList.length];
        boolean[] visited = new boolean[graph.adjList.length];

        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.dist));
        pq.offer(new Vertex(start, 0));

        while (!pq.isEmpty()) {
            Vertex curr = pq.poll();
            int currId = curr.id;

            if (visited[currId]) {
                continue;
            }
            visited[currId] = true;

            // List<Edge> neighbors = graph.getNeighbors(currId);
            for (int dest = 0; dest < graph.adjList[currId].length; dest++) {
                if (graph.adjList[currId][dest] == NOT_CONNECTED) {
                    continue;
                }
                int weight = graph.adjList[currId][dest];
                int newDist = distances[currId] + weight;

                if (newDist < distances[dest]) {
                    distances[dest] = newDist;
                    pq.offer(new Vertex(dest, newDist));
                }
            }
        }

        return distances;
    }

}
