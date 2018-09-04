package treeProblems;

import tree.TreeNode;
import java.util.*;


public class LevelorderReconstructCompleteBinaryTree {
    public TreeNode construct(int[] level) {
        // Write your solution here
        if (level == null || level.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(level[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int index = 1;
        while (index < level.length) {
            TreeNode cur = queue.pollFirst();
            cur.left = new TreeNode(level[index++]);
            if (index >= level.length) break;
            cur.right = new TreeNode(level[index++]);
            queue.offerLast(cur.left);
            queue.offerLast(cur.right);
        }
        return root;
    }
}


