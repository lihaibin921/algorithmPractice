package Offer.LinkedList;

/**
 * 返回链表中倒数第k个节点
 *      这里用双指针法
 *          p先走k步 然后pq一起走 p到头时 q就是在倒数第k个位置上了
 */
public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode findKthToTail(ListNode head , int k){

        if(head == null || k == 0)
            return null;

        ListNode p = head;
        ListNode q = head;

        for(int i = 0 ; i < k ; i ++){
            if(p == null)
                return null;
            p = p.next;
        }

        while(p != null){
            p = p.next;
            q = q.next;
        }

        return q;
    }
}
