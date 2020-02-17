package CrossTraining5;


public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        if (source.length() == 0 || target.length() == 0) {
            return 0;
        }
        int l = 0;
        int[][] array = new int[source.length() + 1][target.length() + 1];
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                    l = Math.max(array[i][j], l);
                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }
        return l;
    }
}


