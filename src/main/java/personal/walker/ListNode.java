package personal.walker;

import java.util.Arrays;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode convertArrayToListNode(int[] nums){
        ListNode root = new ListNode();
        ListNode result = root;
        for (int index = 0; index < nums.length;index++){
            result.val = nums[index];
            if (index < nums.length - 1){
                result.next = new ListNode();
            }
            result = result.next;
        }
        return root;
    }
    public void print(){
        ListNode nextCopy = next;
        System.out.print(val +  ",");
        while (nextCopy != null){
            System.out.print(nextCopy.val +  ",");
            nextCopy = nextCopy.next;
        }
        System.out.println();
    }
}
