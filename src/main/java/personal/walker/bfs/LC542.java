package personal.walker.bfs;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC542 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * bfs , 最短路径搜索
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int[][] matDistances = new int[mat.length][mat[0].length];
        for (int[] distances : matDistances){
            Arrays.fill(distances,Integer.MAX_VALUE >> 1);
        }
        for (int i = 0; i < mat.length;i++){
            for (int j = 0; j < mat[0].length;j++){
                if (mat[i][j] == 0){
                   // dfs(mat,0,i,j,matDistances);
                    bfs(mat,i,j,matDistances);
                    break;
                }
            }
        }
        return matDistances;
    }

    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void bfs(int[][] mat, int row, int column , int[][]distances){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,column});
        int levelNum = 1;
        distances[row][column] = 0;
        while (!queue.isEmpty()){
            int newLevelNum = 0;
            while (levelNum > 0){
                int[] point = queue.poll();
                row = point[0];
                column  = point[1];
                for (int[] direction : directions){
                    int rowN = row + direction[0];
                    int columnN = column + direction[1];
                    int distance;
                    if (rowN < 0 || rowN > mat.length || columnN < 0 || columnN > mat[0].length){
                        continue;
                    }
                    if (mat[rowN][columnN] == 0){
                        distance = 0;
                    }else {
                        distance = distances[row][column] + 1;
                    }
                    if (distance < distances[rowN][columnN]){
                        distances[rowN][columnN] = distance;
                        queue.add(new int[]{rowN,columnN});
                        newLevelNum++;
                    }
                }
                levelNum--;
            }
            levelNum =newLevelNum;
        }
    }

    /**
     * 1. 遇到 0 ，则distance = 0 且 想四个方向搜索，将
     * @param mat
     * @param distance
     * @param row
     * @param column
     * @param distances
     */
     public void dfs(int[][] mat, int distance, int row, int column , int[][]distances){
        if (row < 0 || row >= mat.length || column < 0 || column >= mat[0].length){
            return;
        }
        if (mat[row][column] == 0){
            distance = 0;
        }
        // visited,且没有更短的路径
        if (distances[row][column] <= distance){
            return;
        }
        //
        distances[row][column] = distance;
        for (int[] direction : directions){
            dfs(mat,distance+1,row+ direction[0],column + direction[1],distances);
        }
    }
}
