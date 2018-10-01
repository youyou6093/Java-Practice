package class16DP;

//checked
public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxL = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxL = Math.max(maxL, dp[i][j]);
                }
            }
        }
        return maxL;
    }
}
