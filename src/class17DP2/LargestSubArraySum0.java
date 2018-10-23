package class17DP2;

//checked
public class LargestSubArraySum0 {
    public int largestSum(int[] array) {
        int n = array.length;
        int maxSum = array[0];
        int curMax = array[0];
        for (int i = 1; i < n; i++) {
            curMax = Math.max(curMax + array[i], array[i]);
            maxSum = Math.max(curMax, maxSum);
        }
        return maxSum;
    }
}


