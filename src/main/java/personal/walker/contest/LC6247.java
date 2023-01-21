package personal.walker.contest;

import personal.walker.ListNode;
import personal.walker.Solution;

import java.awt.*;
import java.util.Stack;

public class LC6247 implements Solution {
    @Override
    public void runTestCases() {

    }


    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode result = null;
        while (head != null) {
            while (!stack.isEmpty() && stack.peek().val < head.val) {
                stack.pop();
            }
            if (stack.isEmpty()){
                result = head;
            }else {
                stack.peek().next = head;
            }
            stack.push(head);
            head = head.next;
        }
        return result;
    }
}
