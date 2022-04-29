package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.Stack;

public class LC173 implements Solution {
    @Override
    public void runTestCases() {

    }

    class PrintTreeNode extends TreeNode {

        // 左子树是否已经遍历
        boolean leftScanned;
        // 根是否已经遍历
        boolean rootScanned;
        // 右子树已经遍历
        boolean rightScanned;

        public PrintTreeNode() {
        }

        public PrintTreeNode(TreeNode treeNode) {
            this.val = treeNode.val;
            this.left = treeNode.left;
            this.right = treeNode.right;
        }
    }

    class BSTIterator {
        Stack<TreeNode> nodeStack;
        private void putLeftChildrenIntoStack(TreeNode root){
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
        }
        public BSTIterator(TreeNode root) {
            nodeStack = new Stack<>();
            putLeftChildrenIntoStack(root);
        }

        public int next() {
            TreeNode top = nodeStack.pop();
            if (top.right == null) {
                return top.val;
            }
            putLeftChildrenIntoStack(top.right);
            return  top.val;
        }

        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }
    }
}
