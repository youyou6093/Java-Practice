package treeProblems;

import java.util.*;
import tree.*;
public class MaximumPathSumI {
    public int maxPathSum(TreeNode root) {
        int[] arr = new int[] {Integer.MIN_VALUE};
        if (root == null) {
            return arr[0];
        }
        helper(root, arr);
        return arr[0];
    }
    //return max path from root to leaf
    private int helper(TreeNode root, int[] arr) {
        if (root.left == null && root.right == null) {
            return root.key;
        } else if (root.left != null && root.right != null) {
            int l = helper(root.left, arr);
            int r = helper(root.right, arr);
            arr[0] = Math.max(arr[0], root.key + l + r);
            return root.key + Math.max(l, r);
        } else {
            int childPath = root.left != null ? helper(root.left, arr) : helper(root.right, arr);
            return root.key + childPath;
        }
    }
}
