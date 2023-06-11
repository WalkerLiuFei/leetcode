package personal.walker.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijktra {
    // https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/DijkstrasShortestPathAdjacencyList.java

    /**  Pseudocode ：
     * 1  function Dijkstra(Graph, source):
     * 2      dist[source] ← 0                           // Initialization
     * 3
     * 4      create vertex priority queue Q
     * 5
     * 6      for each vertex v in Graph.Vertices:
     * 7          if v ≠ source
     * 8              dist[v] ← INFINITY                 // Unknown distance from source to v
     * 9              prev[v] ← UNDEFINED                // Predecessor of v
     * 10
     * 11         Q.add_with_priority(v, dist[v])
     * 12
     * 13     visited[v] <- FALSE                        // all initial as false
     * 14     while Q is not empty:                      // The main loop
     * 15         u ← Q.extract_min()                    // Remove and return best vertex
     *            visited[u] = true
     * 16         for each neighbor v of u:              // only v that are still in Q
     *                if visited[v] is true {            // you cannot get a short path of a node that you have visited
     *                    continue
     *                }
     * 17             alt ← dist[u] + Graph.Edges(u, v)
     *
     * 18             if alt < dist[v]:
     * 19                 dist[v] ← alt
     * 20                 prev[v] ← u
     * 21                 Q.decrease_priority(v, alt)
     * 22
     * 23     return dist, prev
     */
    class Node {
        // 编号
        int id;
        // int
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    public static class Edge {
        int cost;
        int from, to;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public double dijkstra(int n, List<List<Edge>> graph, int start, int end) {
        // First, init all distance from start as infinite large
        int[] dist = new int[n];
        Arrays.fill(dist, 1 << 31 - 1);

        // From own node to its own, distance is zero
        dist[start] = 0;
        // Make a heap, to compare and pop out the shortest distance....
        PriorityQueue<Node> pq = new PriorityQueue<>(2 * n,Comparator.comparingInt(node -> node.distance));
        // Array used to track which nodes have already been visited.
        boolean[] visited = new boolean[n];
       // Integer[] prev = new Integer[n];
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.id] = true;

            // We already found a better path before we got to
            // processing this node, so we can ignore it.
            if (dist[node.id] < node.distance) continue;

            List<Edge> edges = graph.get(node.id);
            for (Edge edge : edges) {
                // You cannot get a shorter path by revisiting a node you have already visited before.
                if (visited[edge.to]) continue;

                // Relax edge by updating minimum cost if applicable.
                int newDist = dist[edge.from] + edge.cost;
                if (newDist < dist[edge.to]) {
                    //    prev[edge.to] = edge.from;
                    dist[edge.to] = newDist;
                    pq.offer(new Node(edge.to, dist[edge.to]));
                }
            }
            // Once we've visited all the nodes spanning from the end
            // node we know we can return the minimum distance value to
            // the end node because it cannot get any better after this point.
            if (node.id == end) return dist[end];
        }
        // End node is unreachable
        return Double.POSITIVE_INFINITY;
    }

//
//    private int n;
//    private double[] dist;
//    private Integer[] prev;
//    private List<List<Edge>> graph;
//
//    // Run Dijkstra's algorithm on a directed graph to find the shortest path
//    // from a starting node to an ending node. If there is no path between the
//    // starting node and the destination node the returned value is set to be
//    // Double.POSITIVE_INFINITY.
//    public double dijkstra(int start, int end) {
//        // Maintain an array of the minimum distance to each node
//        dist = new double[n];
//        Arrays.fill(dist, Double.POSITIVE_INFINITY);
//        dist[start] = 0;
//
//        // Keep a priority queue of the next most promising node to visit.
//        PriorityQueue<Node> pq = new PriorityQueue<>(2 * n, comparator);
//        pq.offer(new Node(start, 0));
//
//        // Array used to track which nodes have already been visited.
//        boolean[] visited = new boolean[n];
//        prev = new Integer[n];
//
//        while (!pq.isEmpty()) {
//            Node node = pq.poll();
//            visited[node.id] = true;
//
//            // We already found a better path before we got to
//            // processing this node so we can ignore it.
//            if (dist[node.id] < node.value) continue;
//
//            List<Edge> edges = graph.get(node.id);
//            for (int i = 0; i < edges.size(); i++) {
//                Edge edge = edges.get(i);
//
//                // You cannot get a shorter path by revisiting
//                // a node you have already visited before.
//                if (visited[edge.to]) continue;
//
//                // Relax edge by updating minimum cost if applicable.
//                double newDist = dist[edge.from] + edge.cost;
//                if (newDist < dist[edge.to]) {
//                    prev[edge.to] = edge.from;
//                    dist[edge.to] = newDist;
//                    pq.offer(new Node(edge.to, dist[edge.to]));
//                }
//            }
//            // Once we've visited all the nodes spanning from the end
//            // node we know we can return the minimum distance value to
//            // the end node because it cannot get any better after this point.
//            if (node.id == end) return dist[end];
//        }
//        // End node is unreachable
//        return Double.POSITIVE_INFINITY;
//    }

}
