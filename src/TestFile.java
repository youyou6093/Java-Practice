import java.util.*;
import tree.*;

public class TestFile {
    public static void main(String[] args) {
        TreeNode root = Tree.constructTree(new Integer[] {null});
        System.out.println(new TestFile().isBST(root));
    }

    public boolean isBST(TreeNode root) {
        TreeNode[] prev = new TreeNode[]{null};
        return check(root, prev);
    }

    public boolean check(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return true;
        }
        if(!check(root.left, prev)) {
            return false;
        }
        if (prev[0] != null && root.key <= prev[0].key) {
            return false;
        }
        prev[0] = root;
        return check(root.right, prev);
    }
}







