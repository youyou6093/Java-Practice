package class24CrossTraining2;


import tree.TreeNode;

public class InsertInBST {
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
            return root;
        } else if (key > root.key) {
            root.right = insert(root.right, key);
            return root;
        } else {
            return root;
        }
    }
}
