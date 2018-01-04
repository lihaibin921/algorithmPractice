package search;

/**
 * 平衡二叉树
 * 需要平衡的情况 1,4 单旋转  2,3双旋转
 * 1   左 - 左 (左儿子 的 左子树 中插入节点 (下同))
 * 2   左 - 右
 * 3   右 - 左
 * 4   右 - 右
 */
public class AVLTree<T extends Comparable<? super T>> {

    public AVLTree() {
        root = null;
    }

    public void insert(T x) {
        root = insert( x, root );
    }

    private AvlNode<T> insert(T x, AvlNode<T> t) {

        if( t == null )
            return new AvlNode<>( x, null, null );

        int compareResult = x.compareTo( t.data );

        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  //重复节点不添加

        return balance( t );
    }

    //计算深度(因为深度已经存储在节点中了 此处不需要递归计算了)
    private int height(AvlNode<T> t) {
        if (t == null) {
            return -1;
        } else {
            return t.height;
        }
    }

    //case 1 左 左
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {

        //平衡过程
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        //更新height
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        //k1 现在是父节点
        return k1;
    }

    //case 4
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {

        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;

        return k2;
    }

    //case 2 相当于先对左子树右旋(4) 后对根左旋(1)
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {

        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);

    }

    //case 3 先对右子树左旋 后 对根右旋
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {

        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);

    }

    //对t节点进行平衡
    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null)
            return null;

        if (height(t.left) - height(t.right) > 1) {
            //case 1
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {//case 2
                t = doubleWithLeftChild(t);
            }
        } else {
            if (height(t.right) - height(t.left) > 1) {
                // 4
                if (height(t.right.right) >= height(t.right.left)) {
                    t = rotateWithRightChild(t);
                } else {//3
                    t = doubleWithRightChild(t);
                }
            }
        }

        //更新height
        t.height = Math.max( height( t.left ), height( t.right ) ) + 1;

        return t;
    }


    //节点
    private static class AvlNode<T> {

        T data;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        public AvlNode(T data, AvlNode<T> left, AvlNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        public AvlNode(T data) {
            this(data, null, null);
        }
    }

    //根节点
    private AvlNode<T> root;


    public static void main(String[] args) {

        AVLTree<Integer> tree = new AVLTree<>();

        /*tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);*/

        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(5);

        System.out.println(".....");
    }

}
