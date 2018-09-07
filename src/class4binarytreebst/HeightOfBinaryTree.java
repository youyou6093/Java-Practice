package class4binarytreebst;
import tree.*;
public class HeightOfBinaryTree {
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}