package class24CrossTraining2;

public class CuttingWood1 {
    public static void main(String[] args) {
        CuttingWood1 test = new CuttingWood1();
        System.out.println(test.minCost(new int[] {3,16,19,28,37,44,47,48,51,52,62},67));
//        System.out.println(test.minCost(new int[] {2,4,7},10));
    }

    public int minCost(int[] cuts, int length) {
        int n = cuts.length;

        //i = 0, 取0
        //i = n + 1, 取length;
        //i = 1 -> n, 取cuts[i - 1]
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2 - i; j++) {
                if (i < 2) {
                    dp[j][i + j] = 0;
                } else {
                    dp[j][i + j] = Integer.MAX_VALUE;
                    int total = access(cuts, i + j, length) - access(cuts, j, length);
                    for (int k = j + 1; k < i + j; k++) {
                        dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k][i + j] + total);
                    }
                }
            }
        }
        return dp[0][n + 1];

    }

    public int access(int[] cuts, int i, int length) {
        if (i == 0) {
            return 0;
        } else if (i > 0 && i <= cuts.length) {
            return cuts[i - 1];
        } else {
            return length;
        }
    }
}
