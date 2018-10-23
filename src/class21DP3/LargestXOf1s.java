package class21DP3;


public class LargestXOf1s {
    public int largest(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] topleft = new int[m][n];
        int[][] topright = new int[m][n];
        int[][] downleft = new int[m][n];
        int[][] downright = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    topleft[i][j] = (i == 0 || j == 0) ? 1 : topleft[i - 1][j - 1] + 1;
                    topright[i][j] = (i == 0 || j == n - 1) ? 1 : topright[i - 1][j + 1] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == 1) {
                    downleft[i][j] = (i == m - 1 || j == 0) ? 1 : downleft[i + 1][j - 1] + 1;
                    downright[i][j] = (i == m - 1 || j == n - 1) ? 1 : downright[i + 1][j + 1] + 1;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret = Math.max(ret, myMin(new int[] {topleft[i][j], topright[i][j], downleft[i][j], downright[i][j]}));
            }
        }
        return ret;

    }

    private int myMin(int[] array) {
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret = Math.min(ret, array[i]);
        }
        return ret;
    }
}
