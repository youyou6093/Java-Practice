package CrossTraining4;


import tree.Tree;
import tree.TreeNode;

public class ReverseBinaryTreeUpsideDown {
    public TreeNode reverse(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverse(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.right = null;
        root.left = null;
        return newRoot;
    }

    public TreeNode reverse2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode pre = null;
        TreeNode rightBackup = null;
        while (root != null) {
            TreeNode next = root.left;
            TreeNode temp = root.right;
            root.right = rightBackup;
            root.left = pre;
            rightBackup = temp;
            pre = root;
            root = next;
        }
        return pre;
    }
}
