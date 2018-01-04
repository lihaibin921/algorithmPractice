package Offer.BinaryTree;

import java.util.Random;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *      就是左子树的镜像和右子树相同
 */
public class IsSymmetrical {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static boolean isSymmetrical(TreeNode pRoot) {

        if(pRoot == null)
            return true;

        return isMirror(pRoot.left , pRoot.right);
    }

    private static boolean isMirror(TreeNode t1 , TreeNode t2){
        if(t1 == null && t2 == null)
            return true;

        if(t1 == null || t2 == null)
            return false;

        return t1.val == t2.val && isMirror(t1.left , t2.right ) && isMirror(t1.right , t2.left);
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(isSymmetrical(t1));
    }

}
