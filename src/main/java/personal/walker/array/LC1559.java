package personal.walker.array;

import personal.walker.Solution;

public class LC1559 implements Solution {
    @Override
    public void runTestCases() {
      System.out.println(containsCycle(new char[][]{
              {'a','b','b'},
              {'b','z','b'},
              {'b','b','a'},
//              {'c','c','c'},
//              {'d','d','a'}
      }));
    }

    private static final int INITIAL = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;
    private static final int INVALIED = 3;
    public boolean containsCycle(char[][] grid) {
        int[][] gridState = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length;i++){
            for (int j = 0; j < grid[0].length;j++){
                if (gridState[i][j] != 0){
                    continue;
                }
                if (i == 0 && j == 1){
                    System.out.println("debug");
                }
                if (dfs(grid,i,j,-1,-1,gridState)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 记录上次访问到的节点index ,如果当前index能继续往下走，那么先更新上个index的状态为2(visited),然后继续往下走
     *
     * @param grid
     * @param i
     * @param j
     * @param lastI
     * @param lastJ
     * @param gridState
     * @return
     */

    public boolean dfs(char[][] grid,int i,int j, int lastI,int lastJ,int[][] gridState){
        // if (i < 0 || i > grid.length || j < 0 || j > grid )
        if (gridState[i][j] == VISITED){
            return true;
        }
        if (gridState[i][j] == INVALIED){
            return false;
        }
        boolean left = false,up = false,down = false,right = false;
        if (i > 0 && grid[i-1][j] == grid[i][j]  && !( i - 1 == lastI && j  == lastJ)){
            up = true;
        }
        if (j > 0 && grid[i][j-1] == grid[i][j] && !( i == lastI && j - 1 == lastJ)){

            left = true;
        }
        if (j < grid[0].length - 1 && grid[i][j+1] == grid[i][j]&& !( i == lastI && j + 1 == lastJ)){
            right = true;
        }
        if (i < grid.length - 1 && grid[i+1][j] == grid[i][j]&& !( i+1 == lastI && j  == lastJ)){
            down = true;
        }
        if ((up || right || left || down) && (lastI != -1 && lastJ != -1)){
            gridState[lastI][lastJ] = VISITED;
        }
        if ( up && dfs(grid,i-1,j,i,j,gridState) ){
            return true;
        }
        if (left && dfs(grid,i,j-1,i,j,gridState)){
            return true;
        }
        if (right && dfs(grid,i,j+1,i,j,gridState)){
            return true;
        }
        if (down && dfs(grid,i+1,j,i,j,gridState)){
            return true;
        }
        // 此路不通，标记为无效节点
        gridState[i][j] = INVALIED;
        return false;
    }
}
