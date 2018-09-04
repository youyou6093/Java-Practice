package bfs;

import java.util.*;
import tree.*;

class Temp {
    TreeNode node;
    int index;
    public Temp(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int BinaryTreeMaximumWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Temp> deque = new LinkedList<>();
        deque.offerLast(new Temp(root, 0));
        int width = 0;
        while (!deque.isEmpty()) {
            width = Math.max(deque.peekLast().index - deque.peekFirst().index + 1, width);
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Temp cur = deque.pollFirst();
                if (cur.node.left != null) {
                    deque.offerLast(new Temp(cur.node.left, 2 * cur.index));
                }
                if (cur.node.right != null) {
                    deque.offerLast(new Temp(cur.node.right, 2 * cur.index + 1));
                }
            }
        }
        return width;
    }
}