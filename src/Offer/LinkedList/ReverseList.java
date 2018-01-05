package Offer.LinkedList;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null)
            return null;

        ListNode pre = null;
        ListNode next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}
