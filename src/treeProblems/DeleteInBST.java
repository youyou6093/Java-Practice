package treeProblems;

import java.util.*;
import tree.*;

public class DeleteInBST {
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.key == key) {
            return deleting(root);
        } else if (root.key > key) {
            root.left = delete(root.left, key);
            return root;
        } else {
            root.right = delete(root.right, key);
            return root;
        }
    }

    public TreeNode deleting(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null || root.right == null) {
            return root.left == null ? root.right : root.left;
        } else {
            if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode pre = root;
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                    pre = cur;
                }
                pre.left = cur.right;
                cur.left = root.left;
                cur.right = root.right;
                return cur;
            }
        }

    }
}
