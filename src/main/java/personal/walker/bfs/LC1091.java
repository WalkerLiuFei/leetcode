package personal.walker.bfs;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC1091 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(shortestPathBinaryMatrix(Util.convertTwoDimensionToIntegerArray("" +
                "[" +
                "[0,0,1,0,0,0,0]," +
                "[0,1,0,0,0,0,1]," +
                "[0,0,1,0,1,0,0]," +
                "[0,0,0,1,1,1,0]," +
                "[1,0,0,1,1,0,0]," +
                "[1,1,1,1,1,0,1]," +
                "[0,0,1,0,0,0,0]]")));

        System.out.println(shortestPathBinaryMatrix(Util.convertTwoDimensionToIntegerArray("[[1,0,0],[1,1,0],[1,1,0]]")));
    }

    int INITIAL = Integer.MAX_VALUE >> 1;
    int VISITED = (Integer.MAX_VALUE >> 1) - 2;


    int[][] directions = new int[][]{{1, 1}, {1, 0}, {0, 1}, {1, -1}, {-1, 1}, {0, -1}, {-1, 0}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length- 1] == 1){
            return -1;
        }
       int[][] visited = new int[grid.length][grid[0].length];
       Queue<int[]> queue = new LinkedList<>();
       queue.add(new int[]{0,0});
       int levelNum = 1;
       visited[0][0] = 1;
       while (!queue.isEmpty()){
           int newLevelNum = 0;
           while (levelNum > 0){
               int[] point = queue.poll();
               levelNum -= 1;
               for(int[] direction : directions){
                   int in = point[0] + direction[0];
                   int jn = point[1] + direction[1];
                   if (in < 0 || in >= grid.length || jn < 0 || jn >= grid[0].length || grid[in][jn] != 0 ||
                           (visited[in][jn] <= visited[point[0]][point[1]] + 1 && visited[in][jn] != 0)) {
                       continue;
                   }
                   visited[in][jn] = visited[point[0]][point[1]] + 1;
                   queue.add(new int[]{in,jn});
                   newLevelNum++;
               }
           }
           levelNum = newLevelNum;
       }
       return visited[visited.length-1][visited.length - 1] == INITIAL ? -1 : visited[visited.length-1][visited.length - 1];
    }



    public int dfs(int[][] grid, int i, int j,int[][] visited) {

        if (visited[i][j] <= VISITED){
            return visited[i][j];
        }
        visited[i][j] = VISITED;
        if (i == grid.length - 1 && j == grid[0].length - 1){
            visited[i][j] = 1;
            return visited[i][j];
        }

        for (int[] direction : directions) {
            visited[i][j] = Math.min(dfs(grid,i + direction[0],j+direction[1],visited) + 1,visited[i][j]);
        }
        System.out.printf("%d,%d,%d\n",i,j,visited[i][j]);
        return visited[i][j];
    }
}
