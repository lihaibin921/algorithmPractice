package Offer.BinaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * 二叉树镜像
 *
 * mirror函数 后序递归遍历的思想
 */
public class Mirror {

    public static class TreeNode {
        int val = 0;

        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode init(){

        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(11);

        /*n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        return n1;*/

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;

        return n1;
    }

    private static void mirror(TreeNode root){

        if(root != null){

            mirror(root.left);
            mirror(root.right);

            //刚开始想的复杂了  考虑了左值为空的情况  其实根本没有
            //例如root.left在左侧表示一个引用而已指向null但是本身 根本不是null
            /*if(root.left != null && root.right != null){
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
            }else if(root.left != null){
                root.right = root.left;
                root.left = null;
            }else if(root.right != null){
                root.left = root.right;
                root.right = null;
            }*/

            if(root.left != null || root.right != null){
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
            }
        }

    }


    public static void main(String[] args) {

        TreeNode root = init();

        mirror(root);

        System.out.println("sssss");

    }

}
