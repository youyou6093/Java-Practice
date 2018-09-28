package class12Recursion2;
import tree.TreeNode;


//checked
public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}
