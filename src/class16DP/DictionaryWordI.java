package class16DP;

//checked
import java.util.HashSet;
public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        HashSet<String> set = new HashSet<>();
        for(String str : dict) {
            set.add(str);
        }
        int n = input.length();
        boolean[] dp = new boolean[n + 1]; // boolean 0 is dummy. dp[n] means string[0 : n - 1] is breakable
        dp[0] = true;
        //whether i is the true. [0: i - 1] is breakable
        for (int i = 1; i <= n; i++) {
            //dp[j] is true and s[j, i - 1] is a string
            for (int j = 0; j < i; j++) {
                if (set.contains(input.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
