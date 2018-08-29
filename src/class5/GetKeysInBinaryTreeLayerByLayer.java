package class5;
import tree.TreeNode;
import java.util.*;


public class GetKeysInBinaryTreeLayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here
        List<List<Integer>> ret = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ret.add(new ArrayList<Integer>());
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                ret.get(ret.size() - 1).add(cur.key);
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
            }
        }
        return ret;
    }
}
