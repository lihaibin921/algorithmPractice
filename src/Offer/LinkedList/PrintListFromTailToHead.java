package Offer.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //第一种投机取巧式  正着打印进list 然后倒序list
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(list);
        return list;
    }

    // 第二种 正经的 用栈
    public ArrayList<Integer> printListFromTailToHead2 (ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<ListNode> stack = new LinkedList<>();

        while (listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }

        while(!stack.isEmpty()){
            list.add(stack.pop().val);
        }

        return list;
    }


}
