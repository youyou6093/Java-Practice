package tree;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

    public static int binaryTreeWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> q = new LinkedList<>();
        Deque<Integer> p = new LinkedList<>();
        q.offerLast(root);
        p.offerLast(1);
        int maxWidth = 0;
        while (!q.isEmpty()) {
            maxWidth = Math.max(p.peekLast() - p.peekFirst() + 1, maxWidth);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curPos = p.pollFirst();
                TreeNode cur = q.pollFirst();
                if (cur.left != null) {
                    p.offerLast(curPos * 2 - 1);
                    q.offerLast(cur.left);
                }
                if (cur.right != null) {
                    q.push(cur.right);
                    p.offerLast(curPos * 2);
                }
            }
        }
        return maxWidth;
    }

    public static int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(depthOfTree(root.left), depthOfTree(root.right)) + 1;
        }

    }
}