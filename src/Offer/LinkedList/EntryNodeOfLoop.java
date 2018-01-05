package Offer.LinkedList;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null)
            return null;

        ListNode p = pHead;
        ListNode q = pHead.next;

        while (p != null && q != null) {
            if (p == q){
                //return p; 现在p就是交点
                p = p.next;
                for(;;){
                    if(p == pHead)
                        return p;
                    p = p.next;
                    pHead = pHead.next;
                }
            }

            p = p.next;

            if (q.next == null)
                return null;
            q = q.next.next;
        }

        return null;

    }
}
