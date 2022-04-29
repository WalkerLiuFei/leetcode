package personal.walker.a.notes;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1631 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(minimumEffortPath(Util.convertTwoDimensionToIntegerArray(
               "[[4,3,4,10,5,5,9,2],[10,8,2,10,9,7,5,6],[5,8,10,10,10,7,4,2],[5,1,3,1,1,3,1,9],[6,4,10,6,10,9,4,6]]")));;
    }

    /**
     * bfs 每次找最小高度差的格子作为下一个
     *
     * @param heights
     * @return
     */
    /**
     * 利用
     */

    // 用于四个方向的遍历而已，没什么特殊含义
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        // 分别是 row，column，distance : 含义就是距离坐标 (0,0)的距离。利用一个小顶堆将距离最近的坐标先拿出来。然后将坐标设置为seen,这样可以将复杂度降低
        pq.offer(new int[]{0, 0, 0});
        // 距离起点 (0,0)初始化都是 max value。
        int[] dist = new int[m * n];
        // Dijkastra 算法初始化距离 都是
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 这里的index其实 是
        dist[0] = 0;
        boolean[] seen = new boolean[m * n];

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int x = edge[0], y = edge[1], d = edge[2];
            // 这里这么做加个id的含义其实只是为了做Hash而已，可以理解为一个HashSet
            int id = x * n + y;
            if (seen[id]) {
                continue;
            }
            if (x == m - 1 && y == n - 1) {
                break;
            }
            // 标识此节点已访问过
            seen[id] = true;
            for (int i = 0; i < 4; ++i) {
                // next x,y 坐标 nx,ny
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
                        // 更新 nx,ny 距离 0，0最近权重，其实就是
                        Math.max(d, Math.abs(heights[x][y] - heights[nx][ny])) < dist[nx * n + ny]) {
                    dist[nx * n + ny] = Math.max(d, Math.abs(heights[x][y] - heights[nx][ny]));
                    pq.offer(new int[]{nx, ny, dist[nx * n + ny]});
                }
            }
        }

        return dist[m * n - 1];
    }
}
