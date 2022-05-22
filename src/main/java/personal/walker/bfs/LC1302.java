package personal.walker.bfs;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC1302 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root == null){
            return  0;
        }
        nodeQueue.add(root);
        int levelCount = 1;
        int result = 0;
         while (!nodeQueue.isEmpty()){
            int newLevelCount = 0;
            result = 0;
            while (levelCount-- > 0){
                TreeNode node = nodeQueue.poll();
                result += node.val;
                if (node.left != null){
                    nodeQueue.add(node.left);
                    newLevelCount++;
                }
                if (node.right != null){
                    nodeQueue.add(node.right);
                    newLevelCount++;
                }
            }
            levelCount = newLevelCount;
        }

        return result;
    }
}
