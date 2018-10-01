package class14DP;


//checked
public class ArrayHopperI {
    public boolean canJump(int[] array) {
        boolean[] dp = new boolean[array.length];
        dp[array.length - 1] = true;
        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < array.length && j <= i + array[i]; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
