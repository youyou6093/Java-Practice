import tree.TreeNode;
import java.util.*;


public class CousinsInBinaryTree {
    public boolean isCousin(TreeNode root, int a, int b) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return false;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag1 = false, flag2 = false;
            for (int i = 0; i < size; i++) {
                flag2 = false;
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    if (cur.left.key == a || cur.left.key == b) {
                        if (flag1 == true) {
                            return true;
                        }
                        flag1 = true;
                        flag2 = true;
                    }
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    if (cur.right.key == a || cur.right.key == b) {
                        if (flag2 == true) {
                            return false;
                        } else if (flag1 == true) {
                            return true;
                        }
                        flag1 = true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCousin2(TreeNode root, int a, int b) {
        HashSet<Integer> set = new HashSet<>();
        return help(root, 0, set, a, b);
    }

    boolean help(TreeNode root, int level, HashSet<Integer> set, int a, int b) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null &&
                (root.left.key == a || root.left.key == b) &&
                (root.right.key == a || root.right.key == b)){
            return false;
        }
        if (root.key == a || root.key == b) {
            if (set.contains(level)) {
                return true;
            } else {
                set.add(level);
            }
        }
        return help(root.left, level + 1, set, a, b) ||
                help(root.right, level + 1, set, a, b);
    }
}
