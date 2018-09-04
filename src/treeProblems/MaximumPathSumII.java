package treeProblems;

import tree.*;

public class MaximumPathSumII {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        int[] arr = new int[] {Integer.MIN_VALUE};
        helper(root, arr);
        return arr[0];
    }


    //return max value from this node down to leaf, can be 0
    private int helper(TreeNode root, int[] arr) {
        if (root == null) {
            return 0;
        }
        int l = helper(root.left, arr);
        int r = helper(root.right, arr);
        int ret = Math.max(0, Math.max(l, r) + root.key);
        arr[0] = Math.max(l + r + root.key, arr[0]);
        return ret;
    }
}