package class24CrossTraining2;
import tree.TreeNode;

public class LargestNuberSmallerBST {
    public int largestSmaller(TreeNode root, int target) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.key == target) {
            return largest(root.left);
        } else if (root.key > target) {
            return largestSmaller(root.left, target);
        } else {
            int ret = largestSmaller(root.right, target);
            return ret == Integer.MIN_VALUE ? root.key : ret;
        }
    }

    private int largest(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.right != null) {
            return largest(root.right);
        } else {
            return root.key;
        }
    }
}
