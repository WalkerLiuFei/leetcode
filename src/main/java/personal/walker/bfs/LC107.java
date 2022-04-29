package personal.walker.bfs;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class LC107 implements Solution {
    @Override
    public void runTestCases() {
        TreeNode root = TreeNode.convertArrayToListNode(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);

        Gson gson = new Gson();
        System.out.println(gson.toJson(levelOrderBottom(root)));

        root = TreeNode.convertArrayToListNode(new Integer[]{3}, 0);

        System.out.println(gson.toJson(levelOrderBottom(root)));
    }

    /**
     * 和 顺序的层次遍历一致，不同的是换个方向，如果只是这样应该很简单
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);

        int levelNum = 1;
        while (levelNum > 0) {
            List<Integer> subResult = new ArrayList<>();
            // 这个新层node的数量
            int newLevelNodeNum = 0;
            for (int i = 0; i < levelNum; i++) {
                TreeNode top = queue.poll();
                subResult.add(top.val);
                if (top.left != null) {
                    newLevelNodeNum++;
                    queue.add(top.left);
                }
                if (top.right != null) {
                    newLevelNodeNum++;
                    queue.add(top.right);
                }
            }
            levelNum = newLevelNodeNum;
            result.add(subResult);
        }
        Collections.reverse(result);
        return result;

    }
}
