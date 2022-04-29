package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC538 implements Solution {
    @Override
    public void runTestCases() {

    }
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        travel(root,treeNodeList);
        int sum = 0;
        for (TreeNode treeNode : treeNodeList){
            if (treeNode == null){
                continue;
            }
            treeNode.val += sum;
            sum += treeNode.val;
        }
        return root;
    }

    // 中序遍历
    private void travel(TreeNode node, List<TreeNode> treeNodeList){
        if (node == null){
            treeNodeList.add(node);
            return;
        }
        travel(node.right,treeNodeList);
        treeNodeList.add(node);
        travel(node.left,treeNodeList);
    }

}
