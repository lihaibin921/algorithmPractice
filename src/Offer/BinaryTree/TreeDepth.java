package Offer.BinaryTree;

/**
 * 求二叉树的深度
 */
public class TreeDepth {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int TreeDepth(TreeNode root) {

        if(root == null)
            return -1;

        return Math.max(TreeDepth(root.left) , TreeDepth(root.right)) + 1;
    }
}
