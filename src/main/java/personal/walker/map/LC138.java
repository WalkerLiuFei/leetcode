package personal.walker.map;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC138 implements Solution {
    @Override
    public void runTestCases() {

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     1. 第一遍遍历生成一个  Origin Node -> new Create Node 的map映射
     2. 第二遍遍历 origin node 找到对应的node
     **/
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        //  Origin Node -> new Create Node
        Map<Node,Node> mapper = new HashMap<Node,Node>();
        Node result  = new Node(head.val);
        Node resultCpy = result;
        Node headCpy = head;
        mapper.put(headCpy,resultCpy);

        while(headCpy.next != null){
            resultCpy.next = new Node(headCpy.next.val);
            mapper.put(headCpy.next,resultCpy.next);
            headCpy = headCpy.next;
            resultCpy = resultCpy.next;
        }
        headCpy = head;
        while(headCpy != null){
            mapper.get(headCpy).random = mapper.get(headCpy.random);
            headCpy = headCpy.next;
        }
        return result;
    }
}
