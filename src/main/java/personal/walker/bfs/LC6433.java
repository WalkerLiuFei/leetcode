package personal.walker.bfs;

import personal.walker.Solution;

import java.nio.channels.Pipe;
import java.util.LinkedList;
import java.util.Queue;

public class LC6433 implements Solution {
    @Override
    public void runTestCases() {

    }


    class Point {
        int row;
        int column;
        int value;

        public Point(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

    public int maxMoves(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            int current = 0;
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(i,0,grid[i][0]));
            int levelNum = 1;
            while (!queue.isEmpty()) {
                int newLevelNum = 0;
                while (levelNum > 0) {
                    Point point = queue.poll();
                    if (point.row > 0 && point.column < grid[0].length - 1 && grid[point.row - 1][point.column + 1] > point.value){
                        queue.add(new Point(point.row - 1,point.column + 1,grid[point.row - 1][point.column + 1]));
                        newLevelNum++;
                    }
                    if (point.column < grid[0].length - 1 && grid[point.row][point.column + 1] > point.value){
                        queue.add(new Point(point.row,point.column,grid[point.row][point.column + 1]));
                        newLevelNum++;
                    }
                    if (point.row < grid.length - 1 && point.column < grid[0].length - 1 && grid[point.row + 1][point.column + 1] > point.value){
                        queue.add(new Point(point.row + 1,point.column + 1,grid[point.row + 1][point.column + 1]));
                        newLevelNum++;
                    }
                    levelNum--;
                }
                levelNum = newLevelNum;
                max = Math.max(max,current);
                current++;
            }
        }
        return max;
    }
}
