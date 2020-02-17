package CrossTraining6;
import java.util.*;


public class MaximumValuesOfWindow {
    public List<Integer> maxWindows(int[] nums, int k) {
        Deque<int[]> deque = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //如果新加入的元素比队列尾部元素大的话，弹出队尾元素，加入新元素
            if (deque.isEmpty() || nums[i] < deque.peekLast()[1]) {
                deque.offerLast(new int[] {i, nums[i]});
                //否则只加入新元素
            } else {
                while (!deque.isEmpty() && nums[i] >= deque.peekLast()[1])   deque.pollLast();
                deque.offerLast(new int[]{i, nums[i]});
            }
            //如果window size不够，则直接加入
            //否则视情况把队顶元素弹出
            if (i >= k - 1) {
                if (deque.peekFirst()[0] <= i - k) {
                    deque.pollFirst();
                }
                ret.add(deque.peekFirst()[1]);
            }
        }
        return ret;
    }
};