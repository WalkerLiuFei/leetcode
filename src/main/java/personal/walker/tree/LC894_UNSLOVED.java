package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC894_UNSLOVED implements Solution {
    @Override
    public void runTestCases() {
        List<TreeNode> treeNodes = allPossibleFBT(7);
        for (TreeNode treeNode : treeNodes){
            TreeNode.print2DUtil(treeNode,3);
        }
        treeNodes = allPossibleFBT(5);
        for (TreeNode treeNode : treeNodes){
            TreeNode.print2DUtil(treeNode,3);
        }
    }
    public List<TreeNode> allPossibleFBT(int n) {
        if (n %2 == 0){
            return null;
        }
        TreeNode root = new TreeNode(0);
        return recursive(n - 1);
    }

    /**
     *
     * @param n
     * @return
     */
    public List<TreeNode> recursive( int n){
        List<TreeNode> result = new ArrayList();
        // 到达了子节点
        if (n <= 0){
             result.add(null);
             return result;
        }
        // 倒数第二层的子节点
        n -= 2;
        List<TreeNode> leftListNode = recursive(n);
        List<TreeNode> rightListNode = recursive(n);
        for (TreeNode treeNode : leftListNode){
            TreeNode rootNode = new TreeNode(0);
            result.add(rootNode.left = treeNode);
        }
        for (TreeNode treeNode : rightListNode){
            TreeNode rootNode = new TreeNode(0);
            result.add(rootNode.right = treeNode);
         }
        return result;
    }
}
