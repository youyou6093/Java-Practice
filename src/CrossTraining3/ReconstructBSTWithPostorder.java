package CrossTraining3;


import tree.Tree;
import tree.TreeNode;

public class ReconstructBSTWithPostorder {
    public TreeNode reconstruct(int[] post) {
        return helper(post, 0, post.length - 1);
    }

    public TreeNode helper(int[] post, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(post[right]);
        int index = findSmaller(post, root.key, left, right - 1);
        root.left = helper(post, left, index);
        root.right = helper(post, index + 1, right - 1);
        return root;
    }

    //find the first index that is smaller than root
    public int findSmaller(int[] post, int val, int left, int right) {
        int i = right;
        for (i = right; i >= left; i--) {
            if (post[i] < val) {
                return i;
            }
        }
        return i;
    }
}

