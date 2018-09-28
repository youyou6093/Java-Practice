package class6heapbfs;
import tree.TreeNode;
import java.util.*;

public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left != null) {
                    if (flag == true) {
                        return false;
                    } else {
                        queue.offerLast(cur.left);
                    }
                } else {
                    flag = true;
                }
                if (cur.right != null) {
                    if (flag == true) {
                        return false;
                    } else {
                        queue.offerLast(cur.right);
                    }
                } else {
                    flag = true;
                }
            }
        }
        return true;
    }
}
