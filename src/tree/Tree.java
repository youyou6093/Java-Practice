package tree;

import java.util.Deque;
import java.util.LinkedList;

public class Tree {
    public static TreeNode constructTree(Integer[] array) {
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        int index = 1;
        queue.offerLast(root);
        while (index < array.length) {
            TreeNode cur = queue.pollFirst();
            if (cur == null) continue;
            cur.left = array[index] == null ? null : new TreeNode(array[index]);
            index++;
            if (index >= array.length) break;
            cur.right = array[index] == null ? null : new TreeNode(array[index]);
            index++;
            if (index >= array.length) break;
            queue.offerLast(cur.left);
            queue.offerLast(cur.right);
        }
        return root;

    }
}