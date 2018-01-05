package Offer.BinaryTree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
 * 思路: 感觉是中序遍历相关的
 *      剑指上的答案我没看  据说蛮绕的  我感觉自己写的已经蛮清晰了 下面有注解
 */
public class Convert {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //Convert返回值是链表的第一个节点
    public static TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null)
            return null;

        //利用中序遍历的过程 先将左子树转化成链表
        TreeNode lt = Convert(pRootOfTree.left);

        //如果左子树存在
        if (lt != null) {
            TreeNode last = getLast(lt);
            //父节点的 左节点应该是左子树链表的最后一个节点
            pRootOfTree.left = last;
            //在链表上添加 父节点
            last.right = pRootOfTree;
            //大概就变成了  左->中  左<-中
        }

        //这步用来转化右子树  同上
        TreeNode rt = Convert(pRootOfTree.right);

        if (rt != null) {
            pRootOfTree.right = rt;
            rt.left = pRootOfTree;
        }

        //返回值应该是链表的头节点  不是 lt 就是 pRootOfTree
        return (lt == null) ? pRootOfTree : lt;
    }

    //辅助用的  用来返回链表的最后一个节点
    private static TreeNode getLast(TreeNode root) {

        if (root == null)
            return null;

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t3.left = t1;

        TreeNode root = Convert(t3);

        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }

    }
}
