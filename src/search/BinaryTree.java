package search;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.LinkedList;

/**
 * 这里只写了二叉树的三序遍历而已
 * 而且没写泛型
 * 其中后序循环有难度
 */
public class BinaryTree {

    //树节点
    private static class Node {

        int data;

        Node lt;

        Node rt;

        public Node(int data, Node lt, Node rt) {
            this.data = data;
            this.lt = lt;
            this.rt = rt;
        }

        public Node(int data) {
            this(data, null, null);
        }
    }

    //树的初始化
    private static Node initTree() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.lt = n2;
        n1.rt = n5;

        n2.rt = n3;

        n3.lt = n4;

        n5.lt = n6;
        n5.rt = n7;

        return n1;
    }

    /**
     * 先序递归遍历二叉树
     *
     * @param root
     */
    public static void printTreeInFirstOrder(Node root) {

        if (root != null) {
            System.out.print(root.data + " , ");
            printTreeInFirstOrder(root.lt);
            printTreeInFirstOrder(root.rt);
        }
    }

    /**
     * 中序递归
     *
     * @param root
     */
    public static void printTreeInOrder(Node root) {
        if (root != null) {
            printTreeInOrder(root.lt);
            System.out.print(root.data + " , ");
            printTreeInOrder(root.rt);
        }
    }

    /**
     * 后序递归
     *
     * @param root
     */
    public static void printTreeInLastOrder(Node root) {
        if (root != null) {
            printTreeInLastOrder(root.lt);
            printTreeInLastOrder(root.rt);
            System.out.print(root.data + " , ");
        }
    }

    /**
     * 先序循环
     *
     * @param root
     */
    public static void printTreeInFirstOrderByLoop(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        Node p = root;

        while (p != null || !stack.isEmpty()) {

            if (p != null) {
                stack.push(p);
                System.out.print(p.data + " , ");
                p = p.lt;
            } else if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.rt;
            }

        }
    }

    /**
     * 中序循环
     *
     * @param root
     */
    public static void printTreeInOrderByLoop(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        Node p = root;

        while (!stack.isEmpty() || p != null) {

            if (p != null) {
                stack.push(p);
                p = p.lt;
            } else if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.data + " , ");
                p = p.rt;
            }
        }

    }

    /**
     * 后序循环
     *
     * @param root
     */
    public static void printTreeInLastOrderByLoop(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        Node p = root;
        Node pre = null;

        //先把左节点全放进栈
        while (p != null) {
            stack.push(p);
            p = p.lt;
        }

        while (!stack.isEmpty()) {

            p = stack.pop();

            //如果右节点没有 或者 被遍历过了 就遍历父节点
            if (p.rt == null || pre == p.rt) {
                System.out.print(p.data + " , ");
                pre = p;
            } else {

                //否则把父节点放回栈 开始遍历右节点
                stack.push(p);
                p = p.rt;

                while (p != null) {
                    stack.push(p);
                    p = p.lt;
                }
            }

        }
    }

    public static void main(String[] args) {
        Node root = initTree();

        System.out.println("先序递归");
        printTreeInFirstOrder(root);
        System.out.println();

        System.out.println("中序递归");
        printTreeInOrder(root);
        System.out.println();

        System.out.println("后序递归");
        printTreeInLastOrder(root);
        System.out.println();

        System.out.println("先序循环");
        printTreeInFirstOrderByLoop(root);
        System.out.println();

        System.out.println("中序循环");
        printTreeInOrderByLoop(root);
        System.out.println();

        System.out.println("后序循环");
        printTreeInLastOrderByLoop(root);
        System.out.println();


    }

}
