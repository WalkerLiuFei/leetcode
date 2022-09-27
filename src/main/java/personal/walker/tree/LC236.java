package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;
import personal.walker.Util;

import java.util.ArrayList;
import java.util.List;

public class LC236 implements Solution {
    @Override
    public void runTestCases() {
        TreeNode root = TreeNode.convertArrayToListNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4},0);
        System.out.println(lowestCommonAncestor(root,new TreeNode(5),new TreeNode(4)).val);
    }

    /**
     * 分三种情况
     * 1. p 和q 在同一个level，那么他们的lcp 就是父子关系
     * 2. p 和q 不在同一个子数下
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new ArrayList<>();
        List<TreeNode> qAncestors = new ArrayList<>();
        dfs(root,p.val,pAncestors);
        dfs(root,q.val,qAncestors);
        int i = pAncestors.size() - 1, j = qAncestors.size() - 1;
        for ( ;i >= 0 && j >= 0; i--,j --){
            if (pAncestors.get(i).val != qAncestors.get(j).val){
                break;
            }
        }
         return pAncestors.get(i + 1);
    }

    public boolean dfs(TreeNode node,int target,List<TreeNode> ancestors){
        if (node == null){
            return false;
        }
        boolean result = dfs(node.right,target,ancestors) || dfs(node.left,target,ancestors);
        if (result){
            ancestors.add(node);
        }
        if (node.val == target){
            ancestors.add(node);
        }
        return result || node.val == target;
    }
}
