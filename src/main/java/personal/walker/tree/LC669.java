package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

public class LC669 implements Solution {
    @Override
    public void runTestCases() {
        TreeNode root = TreeNode.convertArrayToListNode(new Integer[]{3,1,4,null,2},0);
        TreeNode result = trimBST(root,1,2);
        TreeNode.print2DUtil(result,0);
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null){
            return root;
        }
        if (root.val >= low && root.val <= high){
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }else if (root.val < low){
            root = trimBST(root.right,low,high);
        }else if (root.val > high){
            root = trimBST(root.left,low,high);
        }
        return root;
    }
}
