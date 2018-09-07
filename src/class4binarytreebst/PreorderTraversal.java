package class4binarytreebst;
import tree.TreeNode;
import java.util.*;


public class PreorderTraversal {
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            ret.add(cur.key);
        }
        return ret;
    }
}