package personal.walker;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class LC994 implements Solution{
    @Override
    public void runTestCases() {

    }

    class Cell {
        int row,column;
        Cell(int row,int column){
            this.row = row;
            this.column = column;
        }
    }
    public int orangesRotting(int[][] grid) {
        int result = -1;
        Queue<Cell> cellQueue = new ArrayDeque<>();
        for (int i = 0; i < grid.length;i++){
            for (int j = 0; j < grid[0].length;j++){
                if (grid[i][j] == 2){
                    cellQueue.add(new Cell(i,j));
                }
            }
        }
        if (cellQueue.size() == 0){
            for (int i = 0; i < grid.length;i++){
                for (int j = 0; j < grid[0].length;j++){
                    if (grid[i][j] ==1){
                        return -1;
                    }
                }
            }
            return 0;
        }
        while (!cellQueue.isEmpty()){
            int levelNum = cellQueue.size();
            while (levelNum-- > 0){
                Cell cell = cellQueue.poll();
                // rot up
                if (cell.row > 0 && grid[cell.row-1][cell.column] == 1){
                    grid[cell.row-1][cell.column] = 2;
                    cellQueue.add(new Cell(cell.row-1,cell.column));
                }
                // rot down
                if (cell.row < grid.length - 1 && grid[cell.row+1][cell.column] == 1){
                    grid[cell.row+1][cell.column] = 2;
                    cellQueue.add(new Cell(cell.row+1,cell.column));
                }
                // rot left
                if (cell.column > 0 && grid[cell.row][cell.column-1] == 1){
                    grid[cell.row][cell.column-1] = 2;
                    cellQueue.add(new Cell(cell.row,cell.column-1));
                }
                // rot down
                if (cell.column < grid[0].length - 1 && grid[cell.row][cell.column+1] == 1){
                    grid[cell.row][cell.column+1] = 2;
                    cellQueue.add(new Cell(cell.row,cell.column+1));
                }
            }
            result++;
        }
        for (int i = 0; i < grid.length;i++){
            for (int j = 0; j < grid[0].length;j++){
                if (grid[i][j] ==1){
                    return -1;
                }
            }
        }
        return result;
    }


}
