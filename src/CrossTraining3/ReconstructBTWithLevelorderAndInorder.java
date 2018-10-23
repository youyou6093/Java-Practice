package CrossTraining3;
import tree.Tree;
import tree.TreeNode;

public class ReconstructBTWithLevelorderAndInorder {
    public static void main(String[] args) {
        ReconstructBTWithLevelorderAndInorder test = new ReconstructBTWithLevelorderAndInorder();
        test.reconstruct(new int[]{1, 6, 5, 7, 4, 10, 9}, new int[] {4, 1, 10, 5, 9, 6, 7});
    }

    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        return helper(inOrder, levelOrder, 0, inOrder.length - 1);
    }

    //pos is the current position in levelOrder
    public TreeNode helper(int[] inOrder, int[] levelOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        //find the position of the root
        int index = find(inOrder, left, right, levelOrder[0]);
        //create the root
        TreeNode root = new TreeNode(inOrder[index]);
        //left part of the inorder
        int[] leftTree = new int[index - left];
        //right part of the inorder
        int[] rightTree = new int[right - index];
        //get the left part and the right part of the level order
        splitTree(levelOrder, leftTree, inOrder, left, index - 1);
        splitTree(levelOrder, rightTree, inOrder, index + 1, right);
        root.left = helper(inOrder, leftTree, left, index - 1);
        root.right = helper(inOrder, rightTree, index + 1, right);
        return root;
    }
    //find the index of a number in an array
    private int find(int[] array, int left, int right, int num) {
        for (int i = left; i <= right; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

    private void splitTree(int[] levelOrder, int[] newTree, int[] inOrder, int left, int right) {
        int index = 0;   //left part of the tree
        for (int i = 0; i <= levelOrder.length - 1; i++) {
            if (find(inOrder, left, right, levelOrder[i]) != -1) {
                newTree[index++] = levelOrder[i];
            }
        }
    }
}

