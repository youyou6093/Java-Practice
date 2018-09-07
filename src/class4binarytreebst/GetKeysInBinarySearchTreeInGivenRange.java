package class4binarytreebst;
import tree.TreeNode;
import java.util.*;

public class GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here
        List<Integer> ret = new ArrayList<>();
        helper(root, min, max, ret);
        return ret;
    }

    public void helper(TreeNode root, int min, int max, List<Integer> ret) {
        if (root == null) {
            return;
        }
        if (root.key > min) {
            helper(root.left, min, max, ret);
        }
        if (root.key >= min && root.key <= max) {
            ret.add(root.key);
        }
        if (root.key < max) {
            helper(root.right, min, max, ret);
        }
    }
}