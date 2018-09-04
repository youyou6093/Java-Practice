package treeProblems;

import tree.TreeNode;
import java.util.*;

public class SecondLargestInBST {
    public int secondLargest(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.right == null) {
            return  largest(root.left);
        } else {
            if (root.right.left == null  && root.right.right == null) {
                return root.key;
            } else {
                return secondLargest(root.right);
            }
        }

    }

    public int largest(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.right == null) {
            return root.key;
        }
        return largest(root.right);
    }


    public int secondLargest2(TreeNode root) {
        int[] array = {0};
        return helper(root, array);
    }

    int helper(TreeNode root, int[] array) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int l1 = helper(root.right, array);
        if (l1 != Integer.MIN_VALUE) {
            return l1;
        }
        if (array[0] == 1) {
            return root.key;
        }
        array[0] += 1;
        return helper(root.left, array);
    }

    public int secondLargest3(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        helper2(root, array);
        return array.size() >= 2 ? array.get(1) : Integer.MIN_VALUE;
    }

    void helper2(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        helper2(root.right, array);
        if (array.size() == 2) {
            return;
        }
        array.add(root.key);
        if (array.size() == 2) {
            return;
        }
        helper2(root.left, array);
    }
}
