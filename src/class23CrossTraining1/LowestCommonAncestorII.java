package class23CrossTraining1;

class TreeNodeP {
    public int key;
    public TreeNodeP left;
    public TreeNodeP right;
    public TreeNodeP parent;
    public TreeNodeP(int key, TreeNodeP parent) {
        this.key = key;
        this.parent = parent;
    }
}


public class LowestCommonAncestorII {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        TreeNodeP root = one;
        if (root == null) {
            return null;
        }
        while (root.parent != null) {
            root = root.parent;
        }
        TreeNodeP ret = helper(root, one, two);
        if (ret != one && ret != two) {
            return ret;
        } else if (ret == one) {
            return helper(root, two, two) != null ? ret : null;
        } else if (ret == two) {
            return helper(root, one, one) != null ? ret : null;
        }
        return ret;
    }

    public TreeNodeP helper(TreeNodeP root, TreeNodeP one, TreeNodeP two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNodeP left = helper(root.left, one, two);
        TreeNodeP right = helper(root.right, one, two);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}