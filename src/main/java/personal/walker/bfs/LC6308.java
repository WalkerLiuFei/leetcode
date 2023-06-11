package personal.walker.bfs;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC6308 implements Solution {
    @Override
    public void runTestCases() {

    }



    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int levelNum = 1;
        while (!queue.isEmpty()){
            int newLevelNum = 0;
            long sum = 0;
            while (levelNum > 0){
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;
                if (treeNode.left != null){
                    queue.add(treeNode.left);
                    newLevelNum++;
                }
                if (treeNode.right != null){
                    queue.add(treeNode.right);
                    newLevelNum++;
                }
                levelNum--;
            }
            pq.add(sum);
            if (pq.size() > k){
                pq.poll();
            }
            levelNum = newLevelNum;
        }
        return pq.size() == k ? pq.peek() : -1;
    }

}
