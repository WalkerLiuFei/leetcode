package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC6182 implements Solution {
    @Override
    public void runTestCases() {
        TreeNode a = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode b = new TreeNode(3, new TreeNode(4, null, null), new TreeNode(5, null, null));
        swap(a, b);
        System.out.println(a.val);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            List<TreeNode> treeNodeList = new ArrayList<>();
            while (levelNum > 0) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    newLevelNum++;
                    queue.add(node.left);
                }
                if (node.right != null){
                    newLevelNum++;
                    queue.add(node.right);
                }
                levelNum--;
                if ((level & 0x01) == 1){
                    treeNodeList.add(node);
                }
            }
            for (int i = 0,j = treeNodeList.size()-1; i < j; i++,j--){
                swap(treeNodeList.get(i),treeNodeList.get(j));
            }
            level++;
            levelNum = newLevelNum;
        }
        return root;
    }

    public void swap(TreeNode a, TreeNode b) {
        int value = a.val;
        a.val = b.val;
        b.val = value;
    }
}
