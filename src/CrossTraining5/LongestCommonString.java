package CrossTraining5;


public class LongestCommonString {
    public String longestCommon(String source, String target) {
        if (source.length() == 0 || target.length() == 0) {
            return "";
        }
        int[][] array = new int[source.length()][target.length()];
        int rb = 0;
        int l = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (source.charAt(i) == target.charAt(j)) {
                    if (i == 0 || j == 0) {
                        array[i][j] = 1;
                    } else {
                        array[i][j] = array[i - 1][j - 1] + 1;
                    }
                    if (array[i][j] > l) {
                        l = array[i][j];
                        rb = i;
                    }
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return source.substring(rb - l + 1, rb + 1);
    }
}
