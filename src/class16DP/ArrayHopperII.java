package class16DP;


public class ArrayHopperII {
    public int minJump(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int curMin = Integer.MAX_VALUE;
            for (int j = i + 1; j <= n - 1 && j <= i + array[i]; j++) {
                curMin = dp[j] != Integer.MAX_VALUE ? Math.min(dp[j] + 1, curMin) : curMin;
            }
            dp[i] = curMin;
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}
