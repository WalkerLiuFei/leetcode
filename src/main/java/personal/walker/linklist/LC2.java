package personal.walker.linklist;

import personal.walker.ListNode;
import personal.walker.Util;

public class LC2 {
    public void runTestCases() {
        ListNode result = addTwoNumbers(ListNode.convertArrayToListNode(new int[]{9, 2, 3, 4, 5, 5}), ListNode.convertArrayToListNode(new int[]{3, 4, 5}));
        Util.printListNode(result);

        result = addTwoNumbers(ListNode.convertArrayToListNode(new int[]{9, 9, 9}), ListNode.convertArrayToListNode(new int[]{9, 9, 9}));
        Util.printListNode(result);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultRoot = new ListNode();
        ListNode result = resultRoot;
        int carry = 0;
        while (true) {
            int value = l1.val + l2.val;
            result.val = value + carry;
            if (result.val > 9) {
                result.val = result.val - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null || l2 == null) {
                break;
            } else {
                result.next = new ListNode();
                result = result.next;
            }
        }

        ListNode notEndListNode = l1 == null ? l2 : l1;
        if (notEndListNode == null) {
            if (carry == 1){
                result.next = new ListNode();
                result.next.val = 1;
            }
            return resultRoot;
        }
        result.next = new ListNode();
        result = result.next;
        while (true) {
            result.val = notEndListNode.val + carry;
            if (result.val > 9) {
                result.val = result.val - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            notEndListNode = notEndListNode.next;
            if (notEndListNode == null) {
                break;
            }
            result.next = new ListNode();
            result = result.next;
        }
        if (carry == 1){
            result.next = new ListNode();
            result.next.val = 1;
        }
        return resultRoot;
    }
}
