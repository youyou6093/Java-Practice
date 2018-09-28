package class5binarytreebst;
import tree.TreeNode;


public class CheckIfBinaryTreeisBalanced {
    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        return checkHeight(root) != -1;
    }

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = checkHeight(root.left);
        if (left == -1) {
            return -1;
        }
        int right = checkHeight(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(right - left) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);

    }
}