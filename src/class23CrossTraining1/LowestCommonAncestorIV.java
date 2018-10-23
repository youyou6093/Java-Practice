package class23CrossTraining1;
import tree.TreeNode;
import java.util.List;

public class LowestCommonAncestorIV {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {

        if (root == null) {
            return null;
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (root == nodes.get(i)) {
                return root;
            }
        }
        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}