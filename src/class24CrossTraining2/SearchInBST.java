package class24CrossTraining2;
import tree.TreeNode;

public class SearchInBST {
    public TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.key) {
            return root;
        } else if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}
