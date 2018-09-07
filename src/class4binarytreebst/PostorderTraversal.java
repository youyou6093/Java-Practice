package class4binarytreebst;
import tree.TreeNode;
import java.util.*;


public class PostorderTraversal {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return ret;
        }
        stack.offerFirst(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    ret.add(cur.key);
                    stack.pollFirst();
                }
            } else if (pre == cur.left) {
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    ret.add(cur.key);
                    stack.pollFirst();
                }
            } else {
                ret.add(cur.key);
                stack.pollFirst();
            }
            pre = cur;
        }
        return ret;
    }
}