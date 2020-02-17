package treeProblems;


import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ReconstructBSTWithLevelOrder {
    public static void main(String[] args) {
        ReconstructBSTWithLevelOrder x = new ReconstructBSTWithLevelOrder();
        TreeNode root = x.reconstruct(new int[] {5, 2, 1, 3});
        System.out.println(root.key);
    }


    public TreeNode reconstruct(int[] level) {
        return helper(level, 0, level.length - 1);
    }

    public TreeNode helper(int[] level, int left, int right) {
        if (left > right) {
            return null;
        }
        int i = left + 1; //beginning of right part
        List<Integer> rightTree = new ArrayList<>();
        for (int j = left + 1; j <= right ; j++) {
            if (level[j] < level[left]) {
                level[i++] = level[j];
            } else {
                rightTree.add(level[j]);
            }
        }
        int border = i;
        for (; i <= right ;i++) {
            level[i] = rightTree.get(i - border);
        }
        TreeNode root = new TreeNode(level[left]);
        root.left = helper(level, left + 1, border - 1);
        root.right = helper(level, border, right);
        return root;

    }





}
