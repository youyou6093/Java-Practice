import java.util.*;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        select(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }

    private void select(int[] nums, int left, int right, int target) {
        if (left >= right) {
            return;
        }
        int pivot = left + (right - left) / 2;
        swap(nums, right, pivot);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (nums[i] >= nums[right]) {
                i++;
            } else {
                swap(nums, i, j--);
            }
        }
        swap(nums, i , right);
        if (i == target) {
            return;
        } else if (i < target) {
            select(nums, i + 1, right, target);
        } else {
            select(nums, left, i - 1, target);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
