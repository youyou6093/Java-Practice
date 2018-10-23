package class24CrossTraining2;


public class MergeStone {
    public int minCost(int[] stones) {
        int n = stones.length;
        if (n == 1 || n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = stones[i] + stones[i + 1];
        }
//        int[] prefix = sumArray(stones);
        //calculate dp[0][i] .. dp[1][i + 1] .. dp[2][i + 2]
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                // calculate dp[j][i + j]
                dp[j][i + j] = Integer.MAX_VALUE;
                int sum = sumValue(stones, j, i + j);
                for (int k = j; k < i + j; k++) {
                    dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + sum);
                }
            }
        }
        return dp[0][n - 1];
    }
    private int sumValue(int[] stones, int left, int right) {
        int ret  = 0;
        for (int i = left; i <= right; i++) {
            ret += stones[i];
        }
        return ret;
    }

//    private int[] sumArray(int[] stones) {
//        int n = stones.length;
//        int[] prefix = new int[n];
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += stones[i];
//            prefix[i] = sum;
//        }
//        return prefix;
//    }
}

