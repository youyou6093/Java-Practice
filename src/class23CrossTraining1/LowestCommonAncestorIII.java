package class23CrossTraining1;


import tree.TreeNode;

public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        TreeNode ret = helper(root, one, two);
        if (ret != one && ret != two) {
            return ret;
        } else if (ret == one) {
            return helper(root, two, two) != null ? ret : null;
        } else if (ret == two) {
            return helper(root, one, one) != null ? ret : null;
        }
        return ret;
    }


    public TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNode left = helper(root.left, one, two);
        TreeNode right = helper(root.right, one, two);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}

