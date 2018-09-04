package treeProblems;

import java.util.*;
import tree.*;

public class MaximumPathSumIII  {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return 0;
        }
        int[] arr = new int[] {Integer.MIN_VALUE};
        helper(root, arr);
        return arr[0];
    }

    private int helper(TreeNode root, int[] arr){
        if (root == null) {
            return 0;
        }
        int l = helper(root.left, arr);
        int r = helper(root.right, arr);
        int ret = Math.max(Math.max(l, r) + root.key, 0);
        arr[0] = Math.max(Math.max(l, r) + root.key, arr[0]);
        return ret;
    }
}
