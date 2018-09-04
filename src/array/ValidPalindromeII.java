package array;

public class ValidPalindromeII {
    public boolean validPalindrome(String input) {
        int i = 0;
        int j = input.length() - 1;
        boolean flag = false;
        while (i < j) {
            if (input.charAt(i) == input.charAt(j)) {
                i++;
                j--;
            } else {
                if(input.charAt(i + 1) == input.charAt(j)) {
                    i++;
                    if (flag) {
                        return false;
                    } else {
                        flag = true;
                    }
                } else if (input.charAt(i) == input.charAt(j - 1)) {
                    j--;
                    if (flag) {
                        return false;
                    } else {
                        flag = true;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
