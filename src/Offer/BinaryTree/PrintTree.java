package Offer.BinaryTree;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 就是广度优先啊(图的算法好久没看了 都忘了)
 * 第一种方式 递归: 就是下面这个注释掉的  虽然牛客网过了 但是根本不对
 * 他在第三层之后又变成了先序遍历
 * <p>
 * 第二种  正确方式 借助队列啊
 */
public class PrintTree {


    public static class TreeNode {
        int val = 0;

        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        //poll出队列 add入队列
        LinkedList<TreeNode> queue = new LinkedList<>();

        TreeNode fa = null;

        if (root == null)
            return list;

        queue.add(root);

        while (!queue.isEmpty()) {
            fa = queue.poll();
            list.add(fa.val);
            if (fa.left != null)
                queue.add(fa.left);
            if (fa.right != null)
                queue.add(fa.right);
        }

        return list;
    }

    //虽然接下来注释的部分错了 但留下来纪念一下2333
    /*public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.add(root.val);

        printTree(list, root);

        return list;
    }

    private static void printTree(ArrayList<Integer> list, TreeNode root) {

        if (root != null) {

            if (root.left != null) {
                list.add(root.left.val);
            }
            if (root.right != null) {
                list.add(root.right.val);
            }

            printTree(list, root.left);
            printTree(list, root.right);

        }

    }*/

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;

        n5.left = n10;
        n5.right = n11;

        n6.left = n12;
        n6.right = n13;

        n7.left = n14;
        n7.right = n15;

        ArrayList<Integer> list = PrintFromTopToBottom(n1);

        System.out.println(list);

    }

}
