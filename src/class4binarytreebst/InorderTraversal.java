package class4binarytreebst;
import tree.TreeNode;
import java.util.*;

public class InorderTraversal {
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.offerFirst(root);
                root = root.left;
            } else {
                root = stack.pollFirst();
                ret.add(root.key);
                root = root.right;
            }
        }
        return ret;

    }
}