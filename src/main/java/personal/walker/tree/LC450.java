package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

public class LC450 implements Solution {
    @Override
    public void runTestCases() {
       TreeNode treeNode =  TreeNode.convertArrayToListNode(new Integer[]{5,3,6,2,4,null,7},0);
       deleteNode(treeNode,3);
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode targetFather = root;
        TreeNode target = root;
        if (target.val == key){
            if (target.left != null){
                target.left.right = target.right;
                return target.left;
            }else{
                return target.right;
            }
        }
        boolean isLeft = true;
        if (root.val > key){
            target = targetFather.left;
        }else{
            isLeft = false;
            target = targetFather.right;
        }

        while (target  != null && target.val != key ){
            targetFather = target;
            //往 left找
            if (target.val > key){
                isLeft = true;
                target = target.left;
            }else{
                isLeft = false;
                target = target.right;
            }
        }
        if (target == null){
            return root;
        }

        if (isLeft){
            if (targetFather.left.right != null){
                targetFather.left.right = targetFather.left.left;
            }else {
                targetFather.left = targetFather.left.left;
            }
        }else{
            if (targetFather.right.right != null){
                targetFather.right.right = targetFather.right.left;
            }else {
                targetFather.right = targetFather.right.left;
            }
        }
        return root;
    }

}
