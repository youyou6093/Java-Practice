package class24CrossTraining2;


import tree.Tree;
import tree.TreeNode;

public class ClosestNumberInBST {
    public int closest(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        int[] close = new int[] {root.key};
        help(root, target, close);
        return close[0];
    }

    void help(TreeNode root, int target, int[] close) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.key - target) < Math.abs(close[0] - target)) {
            close[0] = root.key;
        }
        if (root.key == target) {
            return;
        } else if (root.key < target) {
            //left part of the root can't be answer
            help(root.right, target, close);
        } else {
            //right part of the root can't be answer
            help(root.left, target, close);
        }
    }
}
