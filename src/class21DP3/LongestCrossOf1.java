package class21DP3;



public class LongestCrossOf1 {
    public static void main(String[] args) {
        LongestCrossOf1 x = new LongestCrossOf1();
        System.out.println(x.largest(new int[][] {{1,1,1,0,1}, {1,0,1,1,1}, {1,1,1,1,1}, {1,0,1,1,0},{0,0,1,1,0}}));
    }

    public int largest(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] top = new int[m][n];
        int[][] left = new int[m][n];
        int[][] down = new int[m][n];
        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    top[i][j] = i == 0 ? 1 : top[i - 1][j] + 1;
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                   down[i][j] = i == m - 1 ? 1 : down[i + 1][j] + 1;
                   right[i][j] = j == n - 1 ? 1 : right[i][j + 1] + 1;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret = Math.max(ret, myMin(new int[] {top[i][j], down[i][j], right[i][j], left[i][j]}));
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
