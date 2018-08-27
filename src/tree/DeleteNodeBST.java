package tree;
import java.lang.reflect.Array;
import java.util.Arrays;

public class DeleteNodeBST {
    public static void main(String[] args) {
        Integer[] array = {5,3,6,2,4,null,7};
        TreeNode root = Tree.constructTree(array);
        root = deleteNode(root, 3);
        System.out.println(Arrays.toString(TreeTraversal.preOrder(root).toArray()));
    }


    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode prev = null;
        TreeNode cur = root;
        //find the node
        while (cur != null) {
            if (cur.key < key) {
                prev = cur;
                cur = cur.right;
            } else if (cur.key > key) {
                prev = cur;
                cur = cur.left;
            } else {
                //start deleting
                if (prev == null) {
                    root = deleting(cur);
                } else if (prev.left == cur) {
                    prev.left = deleting(cur);
                } else {
                    prev.right = deleting(cur);
                }
                break;
            }
        }
        return root;
    }

    public static TreeNode deleting(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode prev = root;
            TreeNode cur = root.right;
            //root.right is already the smallest node in the right subtree
            if (cur.left == null) {
                cur.left = root.left;
                return cur;
            }
            //find the smallest node in the right subtree
            while (cur.left != null) {
                prev = cur;
                cur = cur.left;
            }
            prev.left = cur.right;
            cur.right = root.right;
            cur.left = root.left;
            return cur;
        }
    }
}
