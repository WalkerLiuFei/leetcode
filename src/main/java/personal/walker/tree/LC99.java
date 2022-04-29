package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC99 implements Solution {
    @Override
    public void runTestCases() {
        TreeNode treeNode = TreeNode.convertArrayToListNode(new Integer[]{1,2,3},0);
        recoverTree(treeNode);
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        inOrder(root,treeNodes);
        TreeNode wrongNode  = treeNodes.get(0);

        for (int i = 0;i < treeNodes.size() - 1;i ++){

            if (treeNodes.get(i).val > treeNodes.get(i+1).val){
                wrongNode = treeNodes.get(i);
            }
            TreeNode  min = wrongNode;
            for (int j = i+1;j < treeNodes.size();j++){
                if (min.val > treeNodes.get(j).val){
                    min = treeNodes.get(j);
                }
            }
            int temp = wrongNode.val;
            wrongNode.val = min.val;
            min.val = temp;
        }
    }

    private void inOrder(TreeNode node, List<TreeNode> result){
        if (node == null){
            return;
        }
        inOrder(node.left,result);
        result.add(node);
        inOrder(node.right,result);
    }
}
