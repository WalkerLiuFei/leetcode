package personal.walker.array;

import personal.walker.Solution;

public class LC6322 implements Solution {
    @Override
    public void runTestCases() {

    }


    /**
     * [
     * [24,11,22,17,4]
     * [21,16,5,12,9]
     * [6,23,10,3,18]
     * [15,20,1,8,13]
     * [0,7,14,19,2]
     * ]
     *
     * @param grid
     * @return
     */
    public boolean checkValidGrid(int[][] grid) {
        int[][] sorted = new int[grid.length * grid.length][2];
        for (int row = 0; row < grid.length;row++ ){
            for (int column = 0; column < grid[row].length;column++ ){
                sorted[grid[row][column]][0] = row;
                sorted[grid[row][column]][1] = column;
            }
        }
        for (int i = 0; i < sorted.length - 1; i++){
            if(!isValid(sorted[i],sorted[i+1])){
                return false;
            }
        }
        return true;
    }

    boolean isValid(int[] a,int[] b){
        int dr = Math.abs(a[0] - b[0]);
        int dc = Math.abs(a[1] - b[1]);
        if ((dr == 2 && dc == 1) || (dr == 1 && dc == 2)) {
            return true;
        } else {
            return false;
        }
    }

}
