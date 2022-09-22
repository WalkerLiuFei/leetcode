package personal.walker.topologicalsort;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC1857 implements Solution {
    @Override
    public void runTestCases() {
        //System.out.println(largestPathValue("abaca", Util.convertTwoDimensionToIntegerArray("[[0,1],[0,2],[2,3],[3,4]]")));
        //System.out.println(largestPathValue("hhqhuqhqff", Util.convertTwoDimensionToIntegerArray("[[0,1],[0,2],[2,3],[3,4],[3,5],[5,6],[2,7],[6,7],[7,8],[3,8],[5,8],[8,9],[3,9],[6,9]]")));
        System.out.println(largestPathValue("nnllnzznn", Util.convertTwoDimensionToIntegerArray("[[0,1],[1,2],[2,3],[2,4],[3,5],[4,6],[3,6],[5,6],[6,7],[7,8]]")));

    }

    // dp[]
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < colors.length(); i++) {
            neighbors.add(new ArrayList<>());
        }
        int[][] dp = new int[colors.length()][26];
        int[] colorValues = new int[colors.length()];
        for (int i = 0; i < colors.length(); i++) {
            colorValues[i] = colors.charAt(i) - 'a';
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);

        }
        int[] visitedResult = new int[26];
        int result = -1;
        for (int i = 0; i < colors.length(); i++) {
            if (visitedResult[i] != 0) {
                result = Math.max(visitedResult[i], result);
            }
            topologicalSortWithDFS(neighbors, colorValues, i, dp,visitedResult);
        }
        return result;
    }

    // color values means the offset of 'a'

    int[] topologicalSortWithDFS(List<List<Integer>> neighbors,
                                 int[] colorValues, int current, int[][] dp, int[] visited) {
        int VISITING = -3;
        int VISITED = -2;
        // 这是个环,无效，return.
        if (visited[current] == VISITING) {
            return null;
        }
        // already visited, it's result can be reused.
        if (visited[current] == VISITED) {
            // 需要将所有的visited的结果和现在访问到的结果的values 加一起对比才行。
            return dp[current];
        }
        visited[current] = VISITING;
        // 将其值保存在dp里面，等待计算出当前最大的path value
        dp[current][colorValues[current]]++;
        for (int i = 0; i < neighbors.get(current).size(); i++) {
            // 如果这条路下去是一个环，那么当前值就是-1
            int[] result = topologicalSortWithDFS(neighbors, colorValues, neighbors.get(current).get(i), dp, visited);
            // 是一个环，return
            if (result == null) {
                continue;
            }
            dp[current] = getBetterArray(merge(dp[current],result),dp[current]);
        }
        return dp[current];
    }
    int[] merge(int[] a, int[] b) {
        int[] result = new int[26];
        for (int i =0; i < 26; i++){
            result[i] = a[i] + b[i];
        }
        return result;
    }
    int[] getBetterArray(int[] a, int[] b) {
        int aMax = 0;
        for (int aValue : a) {
            aMax = Math.max(aMax, aValue);
        }
        int bMax = 0;
        for (int bValue : a) {
            bMax = Math.max(bMax, bValue);
        }
        if (aMax > bMax) {
            return a;
        }
        return b;
    }
}
