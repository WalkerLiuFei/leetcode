package personal.walker.bfs;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC102 implements Solution {
    @Override
    public void runTestCases() {
        TreeNode root = TreeNode.convertArrayToListNode(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);

        Gson gson = new Gson();
        System.out.println(gson.toJson(levelOrder(root)));

        root = TreeNode.convertArrayToListNode(new Integer[]{3}, 0);

        System.out.println(gson.toJson(levelOrder(root)));


        root = TreeNode.convertArrayToListNode(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);

        System.out.println(gson.toJson(levelOrder2(root)));

        root = TreeNode.convertArrayToListNode(new Integer[]{3}, 0);

        System.out.println(gson.toJson(levelOrder2(root)));
    }

    /*

     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            Queue<TreeNode> newQueue = new ArrayDeque<>();

            while (!queue.isEmpty()) {
                TreeNode top = queue.poll();
                subResult.add(top.val);
                if (top.left != null) {
                    newQueue.add(top.left);
                }
                if (top.right != null) {
                    newQueue.add(top.right);
                }
            }
            result.add(subResult);
            queue = newQueue;
        }
        return result;
    }

    /**
     * 可以使用数量进行优化，一个层有多少node，可以直接记下来
     *
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder2(TreeNode root) {
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
        return result;
    }

}
