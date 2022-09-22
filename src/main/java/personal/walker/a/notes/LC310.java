package personal.walker.a.notes;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC310 implements Solution {
    @Override
    public void runTestCases() {
        // 1,2
        System.out.println(findMinHeightTrees(7, Util.convertTwoDimensionToIntegerArray("[[0,1],[1,2],[1,3],[2,4],[3,5],[4,6]]")));
    }

    /**
      *
     * 首先，我们看了样例，发现这个树并不是二叉树，是多叉树。
     * 然后，我们可能想到的解法是：根据题目的意思，就挨个节点遍历bfs，统计下每个节点的高度，然后用map存储起来，后面查询这个高度的集合里最小的就可以了。
     * 但是这样会超时的。
     * 于是我们看图（题目介绍里面的图）分析一下，发现，越是靠里面的节点越有可能是最小高度树。
     * 所以，我们可以这样想，我们可以倒着来。
     * 我们从边缘开始，先找到所有出度为1的节点，然后把所有出度为1的节点进队列，然后不断地bfs，最后找到的就是两边同时向中间靠近的节点，那么这个中间节点就相当于把整个距离二分了，那么它当然就是到两边距离最小的点啦，也就是到其他叶子节点最近的节点了。
     * 然后，就可以写代码了。
     *
     * 作者：xiao-xin-28
     * 链接：https://leetcode.cn/problems/minimum-height-trees/solution/zui-rong-yi-li-jie-de-bfsfen-xi-jian-dan-zhu-shi-x/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @param srcEdges
     * @return
     */

    public List<Integer> findMinHeightTrees(int n, int[][] srcEdges) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
         for (int[] edge : srcEdges) {
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);

        }
        int[] heights = new int[n];
         Arrays.fill(heights,1 << 31 - 1);
        int minimum = 1 << 31 - 1;
        for (int i = 0; i < n; i++) {
            heights[i] = dfs(edges, i, new int[n], heights,0);
            if (heights[i] < minimum) {
                minimum = heights[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (heights[i] == minimum) {
                result.add(i);
            }
        }
        return result;
    }
    private int dfs(List<List<Integer>> edges, int current, int[] visit,int[] heights, int height) {
        int VISITING = 1;
        // 高度确定
        if (visit[current] == VISITING) {
            return height;
        }
        // 别想了，肯定不是你
        if (heights[current] < height) {
            return 1 << 31 - 1;
        }
        visit[current] = VISITING;
        int result = height;
        for (Integer node : edges.get(current)) {
            result = Math.max(dfs(edges, node, visit, heights,height + 1), result);
        }
        // 高度确定
        return result;
    }

}
