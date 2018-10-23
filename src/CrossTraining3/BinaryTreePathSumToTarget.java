package CrossTraining3;
import tree.TreeNode;
import java.util.HashMap;

public class BinaryTreePathSumToTarget {
    public boolean exist(TreeNode root, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);                //we always have a zero in sum array
        int[] curSum = new int[] {0}; //build a prefix sum
        return helper(root, target, map, curSum);
    }


    public boolean helper(TreeNode root, int target, HashMap<Integer, Integer> map, int[] curSum) {
        if (root == null) {
            return false;
        }
        curSum[0] += root.key;
        if (map.containsKey(curSum[0] - target)) {
            return true;
        }
        Integer count = map.get(curSum[0]);
        if (count == null) {
            map.put(curSum[0], 1);
        } else {
            map.put(curSum[0], count + 1);
        }
        boolean ret = helper(root.left, target, map, curSum) || helper(root.right, target, map, curSum);
        if (count == null) {
           map.remove(curSum[0]);
        }
        curSum[0] -= root.key;
        return  ret;
    }

}
