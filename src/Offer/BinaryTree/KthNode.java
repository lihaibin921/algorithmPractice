package Offer.BinaryTree;

import java.util.LinkedList;

/**
 * 给定一颗二叉搜索树，请找出其中的第k小的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *       就是一个中序遍历而已  我这里用的循环做的
 */
public class KthNode {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot == null || k == 0)
            return null;

        int count = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (pRoot != null || !stack.isEmpty()) {

            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else if (!stack.isEmpty()) {
                pRoot = stack.pop();
                if (++count == k)
                    return pRoot;
                pRoot = pRoot.right;
            }
        }

        return null;
    }
}
