package personal.walker.top.like;

import personal.walker.ListNode;
import personal.walker.Solution;

public class LC1721 implements Solution {
    @Override
    public void runTestCases() {
        ListNode result = ListNode.convertArrayToListNode(new int[]{1, 2, 3, 6, 5, 4});
        swapNodes(result, 2).print();
        result = ListNode.convertArrayToListNode(new int[]{1, 2, 3, 4});
        swapNodes(result, 2).print();
        result = ListNode.convertArrayToListNode(new int[]{1, 2, 3, 4});
        swapNodes(result, 3).print();
        result = ListNode.convertArrayToListNode(new int[]{1, 2, 3});
        swapNodes(result, 2).print();
        result = ListNode.convertArrayToListNode(new int[]{1, 2});
        swapNodes(result, 2).print();
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        int length = 2;

        ListNode headCpy = head;
        while (headCpy.next.next != null) {
            headCpy = headCpy.next;
            length++;
        }
        ListNode result = head;

        int j = length - k + 1;
        ListNode pre = head;
        ListNode back = headCpy;

        for (int i = 1; head != null; i++) {
            if (i == k ) {
                pre = head;
            }
            if (i == j ) {
                back = head;
            }
            head = head.next;
        }
        int temp = pre.val;
        pre.val = back.val;
        back.val = temp;
        return result;
    }
}
