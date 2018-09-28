package class16DP;



public class LargestSubArraySum {
    public int[] largestSum(int[] array) {
        int n = array.length, maxSum = array[0], curMax = array[0];
        int left = 0, right = 0;
        int curLeft = 0, curRight = 0;
        for (int i = 1; i < n; i++) {
            if (curMax >= 0) {
                curMax += array[i];
                curRight++;
            } else {
                curMax = array[i];
                curLeft = i;
                curRight = i;
            }
            if (maxSum < curMax) {
                left = curLeft;
                right = curRight;
                maxSum = curMax;
            }
        }
        return new int[]{maxSum, left, right};
    }
}
