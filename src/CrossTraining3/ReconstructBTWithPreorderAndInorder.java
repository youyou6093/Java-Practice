package CrossTraining3;
import tree.TreeNode;

public class ReconstructBTWithPreorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        return helper(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }


    TreeNode helper(int[] inorder, int[] preorder, int left1, int right1, int left2, int right2) {
        if (left1 > right1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left2]);
        int rootPos = left1;
        for (int i = left1; i <= right1; i++) {
            if (inorder[i] == root.key) {
                rootPos = i;
                break;
            }
        }
        root.left = helper(inorder, preorder, left1, rootPos - 1,
                left2 + 1, left2 + rootPos - left1);
        root.right = helper(inorder, preorder, rootPos + 1, right1,
                left2 + rootPos - left1 + 1, right2);
        return root;
    }
}
