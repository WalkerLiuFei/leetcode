package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.TreeNode;
import personal.walker.Util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC6154 implements Solution {
    @Override
    public void runTestCases() {
//        TreeNode root = TreeNode.convertArrayToListNode(new Integer[]{1,5,3,null,4,10,6,9,2,0},0);
//       System.out.println(amountOfTime(root,3));
//        TreeNode root = TreeNode.convertArrayToListNode(new Integer[]{1},0);
//        System.out.println(amountOfTime(root,1));
        TreeNode root = TreeNode.convertArrayToListNode(new Integer[]{2,5},0);
        System.out.println(amountOfTime(root,5));
     }

    public int amountOfTime(TreeNode root, int start) {
        if (root.val != start){
            mapParent(root,root.left,start);
            mapParent(root,root.right,start);
        }else {
            startNode =  root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int levelNum = 1;
        queue.add(startNode);

        Map<Integer,Boolean> visisted = new HashMap<>();
        visisted.put(startNode.val,true);
        int result = -1;
        // 层序遍历
        while (!queue.isEmpty()){
            int newLevelNum = 0;
            result++;
            while (levelNum > 0){
                TreeNode node = queue.poll();
                if (node.left != null && !visisted.containsKey(node.left.val)){
                    queue.add(node.left);
                    visisted.put(node.left.val,true);
                    newLevelNum++;
                }
                if (node.right != null && !visisted.containsKey(node.right.val)){
                    queue.add(node.right);
                    visisted.put(node.right.val,true);
                    newLevelNum++;
                }
                TreeNode parent = parentMap.get(node.val);
                if (parent != null && !visisted.containsKey(parent.val)){
                    queue.add(parent);
                    visisted.put(parent.val,true);
                    newLevelNum++;
                }
                levelNum --;
            }
            levelNum = newLevelNum;
        }
        return result;
    }

    Map<Integer, TreeNode> parentMap = new HashMap<>();
    TreeNode startNode;

    void mapParent(TreeNode parentNode, TreeNode node,int target) {
        if (node == null){
            return;
        }
        if (node.val == target){
            startNode = node;
        }
        parentMap.put(node.val,parentNode);
        mapParent(node,node.left,target);
        mapParent(node,node.right,target);
    }
}
