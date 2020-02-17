package CrossTraining6;



public class InterleaveStrings {
    public static void main(String[] args) {
        InterleaveStrings test = new InterleaveStrings();
        test.canMerge("abgcd", "bebgf", "abgcdbebg");


    }

    public boolean canMerge(String a, String b, String c) {
        int m = a.length();
        int n = b.length();
        if (c.length() != m + n) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            if (dp[0][i - 1] == true && b.charAt(i - 1) == c.charAt(i - 1)) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            if (dp[i -1][0] == true && a.charAt(i - 1) == c.charAt(i - 1)) {
                dp[i][0] = true;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dp[i - 1][j] == true && c.charAt(i - 1 + j) == a.charAt(i - 1)) dp[i][j] = true;
                if (dp[i][j - 1] == true && c.charAt(i - 1 + j) == b.charAt(j - 1)) dp[i][j] = true;
            }
        }
        return dp[m][n];

    }
}

