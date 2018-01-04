package Offer.BinaryTree;

import java.util.LinkedList;
import java.util.logging.Level;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextNode {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {

        if(pNode == null)
            return null;

        //1 有右子树
        if(pNode.right != null){
            LinkedList<TreeLinkNode> stack = new LinkedList<>();

            pNode = pNode.right;

            while(pNode != null){
                stack.push(pNode);
                pNode = pNode.left;
            }

            return stack.pop();
        }

        //2 有父节点并且是左子树
        if(pNode.next != null && pNode.next.left == pNode)
            return pNode.next;

        //3 pNode是根节点 且没有右子树
        if(pNode.next == null)
            return null;

        //4 有父节点 并且是右子树
        while (pNode.next != null && pNode.next.right == pNode){
            pNode = pNode.next;
        }
        return pNode.next;
    }

    public static void main(String[] args) {

        TreeLinkNode t1 = new TreeLinkNode(8);
        TreeLinkNode t2 = new TreeLinkNode(6);
        TreeLinkNode t3 = new TreeLinkNode(10);
        TreeLinkNode t4 = new TreeLinkNode(5);
        TreeLinkNode t5 = new TreeLinkNode(7);
        TreeLinkNode t6 = new TreeLinkNode(9);
        TreeLinkNode t7 = new TreeLinkNode(11);

        t1.left = t2;
        t1.right = t3;
        t2.next = t1;
        t3.next = t1;

        t2.left = t4;
        t2.right = t5;
        t4.next = t2;
        t5.next = t2;

        t3.left = t6;
        t3.right = t7;
        t6.next = t3;
        t7.next = t3;

        TreeLinkNode t = GetNext(t1);
        System.out.println(t == null ? null : t.val);
    }

}
