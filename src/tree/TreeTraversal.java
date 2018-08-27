package tree;

import java.util.*;

public class TreeTraversal {
    public static void main (String[] args){
        Integer[] array = {5, 6, 7, 8, null, 10, 11};
        TreeNode root = Tree.constructTree(array);
        System.out.println(Arrays.toString(preOrder(root).toArray()));
        System.out.println(Arrays.toString(inOrder(root).toArray()));
        System.out.println(Arrays.toString(postOrder(root).toArray()));

    }

    public static void inOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(root.key);
        inOrderRecursive(root.right);
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ret.add(cur.key);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return ret;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ret.add(root.key);
                root = root.right;
            }
        }
        return ret;
    }

    public static List<Integer> postOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        TreeNode prev = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    ret.add(cur.key);
                    stack.pop();
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    ret.add(cur.key);
                    stack.pop();
                }
            } else  {
                ret.add(cur.key);
                stack.pop();
            }
            prev = cur;
        }
        return  ret;
    }
}
