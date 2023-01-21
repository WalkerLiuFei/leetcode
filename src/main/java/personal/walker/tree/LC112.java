package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

public class LC112 implements Solution {
    @Override
    public void runTestCases() {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum < 0) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        if (hasPathSum(root.left, targetSum - root.val)) {
            return true;
        }
        if (hasPathSum(root.right, targetSum - root.val)) {
            return true;
        }
        return false;
    }
}
