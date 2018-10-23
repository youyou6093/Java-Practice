package class14DP1;

//checked
public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        if (length <= 1) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }
        return dp[length];
    }
}
