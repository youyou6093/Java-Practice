package class17DP2;


//checked
public class EditDistance {
    public int editDistance(String one, String two) {
        int l1 = one.length(), l2 = two.length();
        if (l1 == 0 || l2 == 0) {
            return l1 == 0 ? l2 : l1;
        }
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) dp[i][0] = i;
        for (int i = 0; i <= l2; i++) dp[0][i] = i;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //dp[i - 1][j - 1] means replace;
                    //dp[i - 1][j] means delete i-1 th char from one;
                    //dp[i][j - 1] means insert j - 1th char of two to one
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i -1][j -1] + 1);
                }
            }
        }
        return dp[l1][l2];

    }
}
