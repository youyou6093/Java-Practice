package class16DP;

//checked
public class ArrayHopperII {
    public int minJump(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = -1;
            for (int j = i + 1; j <= n - 1 && j <= i + array[i]; j++) {
                if (dp[j] != -1) {  //can jump
                   if (dp[i] != -1) {
                       dp[i] = Math.min(dp[j] + 1, dp[i]);
                   } else {
                       dp[i] = dp[j] + 1;
                   }
                }
            }
        }
        return dp[0];
    }
}
