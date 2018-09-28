package class12Recursion2;

//checked
public class StringAbbreviationMatch {
    public static void main(String[] args) {
        new StringAbbreviationMatch().match("apple" , "5");
    }

    public boolean match(String input, String pattern) {
        return helper(input, pattern, 0, 0);
    }

    public boolean helper(String input, String pattern, int idx1, int idx2) {
        if (idx1 == input.length() && idx2 == pattern.length()) {
            return true;
        }
        if (idx1 >= input.length() || idx2 >= pattern.length()) {
            return false;
        }
        if (!isNumber(pattern.charAt(idx2))) {
            if (input.charAt(idx1) != pattern.charAt(idx2)) {
                return false;
            } else {
                return helper(input, pattern, idx1 + 1, idx2 + 1);
            }
        } else {
            int num = 0;
            while (idx2 < pattern.length() && isNumber(pattern.charAt(idx2))) {
                num = num * 10 + pattern.charAt(idx2) - '0';
                idx2++;
            }
            return helper(input, pattern, idx1 + num, idx2);
        }
    }

    private boolean isNumber(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }



}
