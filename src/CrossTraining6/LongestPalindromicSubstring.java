package CrossTraining6;



public class LongestPalindromicSubstring {
    public String longestPalindrome(String input) {
        int n = input.length();
        if (n == 0) {
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int len = 1;
        String ret = input.substring(0, 1);
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 1; i >=0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (input.charAt(j) == input.charAt(i)) {
                    if (j == i + 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    }
                    if (dp[i][j] == true && j - i + 1 > len) {
                        len = j - i + 1;
                        ret = input.substring(i, j + 1);
                    }
                }
            }
        }
        return ret;
    }
}
