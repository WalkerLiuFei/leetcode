package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;
import personal.walker.Util;

public class LC1372 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(longestZigZag(TreeNode.convertArrayToListNode(new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1},0)));
    }

    public int longestZigZag(TreeNode root) {
        return Math.max(helper(root.left,true,0),helper(root.right,false,0));
    }




    public int helper(TreeNode node, boolean isRightDir,int currentLength) {
        if (node == null){
            return currentLength;
        }
        currentLength += 1;
        TreeNode nextNode = node.right;
        TreeNode theOtherNode = node.left;
        if (!isRightDir){
            nextNode = node.left;
           theOtherNode = node.right;
        }
        return Math.max(helper(nextNode,!isRightDir,currentLength),helper(theOtherNode,isRightDir,0));
    }
}
