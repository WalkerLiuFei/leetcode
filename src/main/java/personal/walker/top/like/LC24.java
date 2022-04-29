package personal.walker.top.like;

import personal.walker.ListNode;
import personal.walker.Solution;

public class LC24 implements Solution {
    @Override
    public void runTestCases() {
        ListNode result =  ListNode.convertArrayToListNode(new int[]{1,2,3,4});
        swapPairs(result).print();

        result = ListNode.convertArrayToListNode(new int[]{1,2,3,4,5,6,7,8});
        swapPairs(result).print();

        result = ListNode.convertArrayToListNode(new int[]{1,2,3,4,5,6,7,8,9});
        swapPairs(result).print();
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = head.next;
        // 保存下一下
        ListNode temp = head.next.next;
        ListNode headNext = head.next;
        head.next = temp;
        headNext.next = head;

        // let previous is head... do same action like above again
        ListNode previous = head;
        while (previous.next != null && previous.next.next != null){
            head = previous.next;
            temp = head.next.next;
            headNext = head.next;
            head.next = temp;
            headNext.next = head;

            previous.next = headNext;
            previous = head;

        }
        return result;
    }
}
