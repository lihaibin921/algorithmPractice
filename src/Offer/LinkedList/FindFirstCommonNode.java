package Offer.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class FindFirstCommonNode {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }



	//第一种 我的常规操作 找重复直接上set或者map就行了
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        Set<ListNode> set = new HashSet<>();

        while (pHead1 != null){
            set.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            if(set.contains(pHead2))
                return pHead2;
            pHead2 = pHead2.next;
        }

        return null;
    }

    //第二种大神做法 我在下面写第三种算法解读这个
    public static ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        //当p1==p2==null的时候说明肯定没交点 直接退出
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }



    /**
     * 第二种的容易理解的写法(好像也没简单啥)
     *  类似于把两条链表拼接起来 两个指针同时遍历 遇到相同的(不为null)就返回
     *  否则继续向下遍历 直到到头为止  都等于null时表示没有交集
     *
     *  看这个图就懂了 (注意交点之后的部分都是相交的) 第二次到达交点一定是同时的
     *
     *  -----*--- ---*---
     *  ---*--- -----*---
     *
     */
    public static ListNode findFirstCommonNode3(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while(p1 != null || p2 != null){
            if(p1 == p2)
                return p1;

            if(p1 == null)
                p1 = pHead2;
            else
                p1 = p1.next;

            if(p2 == null)
                p2 = pHead1;
            else
                p2 = p2.next;

        }

        return null;
    }

}
