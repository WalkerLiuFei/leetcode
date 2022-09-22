package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6163 implements Solution {
    @Override
    public void runTestCases() {

    }


    /**
     * 使用 bfs遍历的方式
     *
     * @iparam k

     * @return
     */
    class Point {
        int row;
        int column;

        Point(int _row, int _column) {
            this.row = _row;
            this.column = _column;
        }
    }

    int[][] result;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        result = new int[rowConditions.length][colConditions.length];
        HashMap<Integer, List<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, Integer> belowMap = new HashMap<>();
        for (int[] condition : rowConditions) {
            rowMap.putIfAbsent(condition[1], new ArrayList<>());
            rowMap.get(condition[1]).add(condition[0]);
            belowMap.put(condition[0], condition[1]);
        }
        if (rowConditions.length > 0) {
            int lowest = findLowest(belowMap, rowConditions[0][0], new boolean[k]);
            if (lowest == -1) {
                return new int[][]{};
            }
        }
        int rowIndex = colConditions.length - 1;
        Queue<Integer> queue = new LinkedList<>();
        int row = 0;
        int count = 1;

        if (rowConditions.length > 0) {

        }
        HashMap<Integer, Integer> colMap = new HashMap<>();
        for (int[] condition : rowConditions) {
            colMap.put(condition[0], condition[1]);
        }
        boolean[] visited = new boolean[k];
        return new int[][]{};
    }


    void determineRow(HashMap<Integer, List<Integer>> rowMap,int value, int rowIndex) {
        if (rowIndex < 0 ){
            return;
        }

    }

    int findLowest(HashMap<Integer, Integer> belowMap, int value, boolean[] visited) {
        if (visited[value]) {
            return -1;
        }
        // 最底层
        if (belowMap.get(value) == null) {
            return value;
        }
        visited[value] = true;
        return findLowest(belowMap, belowMap.get(value), visited);
    }
}
