package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC101 implements Solution {
    @Override
    public void runTestCases() {

    }

    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left,root.right);
    }

    public boolean isSym(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }
        return isSym(left.left,right.right) && isSym(left.right,right.left);
    }


}
