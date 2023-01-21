package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC623 implements Solution {
    @Override
    public void runTestCases() {

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 1;
        if (depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        depth--;
        while (!queue.isEmpty() && depth > 1){
            int newLevelCount = 0;
            while (levelCount > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                    newLevelCount++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    newLevelCount++;
                }
                levelCount--;
            }
            depth--;
            levelCount = newLevelCount;
        }
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = treeNode.left;
            treeNode.left = newLeft;

            TreeNode newRight = new TreeNode(val);
            newRight.right = treeNode.right;
            treeNode.right = newRight;
        }
        return root;
    }
}
