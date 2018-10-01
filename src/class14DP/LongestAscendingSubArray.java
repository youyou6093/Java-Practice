package class14DP;


//checked
public class LongestAscendingSubArray {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = 1;
        int global = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                global = Math.max(dp[i], global);
            } else {
                dp[i] = 1;
            }
        }
        return global;
    }
}
