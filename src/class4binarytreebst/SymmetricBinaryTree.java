package class4binarytreebst;
import tree.TreeNode;


public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.key != b.key) {
            return false;
        } else {
            return helper(a.left, b.right) && helper(a.right, b.left);
        }
    }
}