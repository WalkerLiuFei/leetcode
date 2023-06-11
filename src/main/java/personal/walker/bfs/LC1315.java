package personal.walker.bfs;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC1315 implements Solution {
    @Override
    public void runTestCases() {

    }

    private class Point{
        TreeNode node;
        boolean isParentEven;
        //boolean isGrandparentEven;

        public Point(TreeNode node, boolean isParentEven) {
            this.node = node;
            this.isParentEven = isParentEven;
           // this.isGrandparentEven = isGrandparentEven;
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(root,false));

        int level = 1;

        while (!queue.isEmpty()){
            int newLevel = 0;
            while (level > 0){
                Point point = queue.poll();
                boolean isParentEven = point.node.val %  2 == 0;
                if (point.node.right != null){
                    queue.add(new Point(point.node.right,isParentEven));
                    if (point.isParentEven){
                        result += point.node.right.val;
                    }
                    newLevel++;
                }
                if (point.node.left != null){
                    queue.add(new Point(point.node.left,isParentEven));
                    if (point.isParentEven){
                        result += point.node.left.val;                    }
                    newLevel++;
                }
                level--;
            }
            level = newLevel;
        }
        return result;
    }
}
