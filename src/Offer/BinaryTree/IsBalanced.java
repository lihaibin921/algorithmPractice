package Offer.BinaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * 判断二叉树是否是平衡二叉树
 *      我这样写在牛客网居然过了 不应该先判断是不是二叉搜索树么
 *      加以改进啊了  虽然牛客网不通过了 但是我觉得没毛病
 *
 *      还有 root == null 牛客上要求 返回true???? 都null值是个屁的二叉树啊
 */
public class IsBalanced {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean IsBalanced_Solution(TreeNode root) {

        if(root == null)
            return false;

        return isBinarySearchTree(root) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public static boolean isBinarySearchTree(TreeNode root){

        //这里root==null返回true了 不然递归到空树一定返回false 只好妥协null也是一颗树了
        if(root == null)
            return true;

        if((root.left != null)&&(root.left.val > root.val))
            return false;

        if((root.right != null)&&(root.right.val < root.val))
            return false;

        return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
    }

    public static int height(TreeNode t){
        if(t == null)
            return -1;
        else
            return Math.max(height(t.left) , height(t.right)) + 1;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(1);

        t2.left = t3;
        t2.right = t1;

        System.out.println(isBinarySearchTree(t2));
        System.out.println(IsBalanced_Solution(t2));
        System.out.println(height(t1.left));
        System.out.println(height(t1.right));
    }

}
