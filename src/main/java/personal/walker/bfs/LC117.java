package personal.walker.bfs;

import personal.walker.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class LC117 implements Solution {
    @Override
    public void runTestCases() {

    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;
        while (!queue.isEmpty()){
            Node leftNode = null;
            int newLevelNum = 0;
            while (levelNum > 0){
                Node node = queue.poll();
                if (leftNode != null){
                    leftNode.next = node;
                 }
                leftNode = node;
                if (node.left != null){
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    newLevelNum++;
                }
                levelNum--;
            }
            levelNum = newLevelNum;
        }
        return root;
    }
}
