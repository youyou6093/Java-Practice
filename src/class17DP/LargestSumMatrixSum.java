package class17DP;


public class LargestSumMatrixSum {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = 0;
        for (int top = 0; top < m; top++) {
            int[] array = new int[n];
            for (int down = top; down < m; down++) {
                for (int column = 0; column < n; column++) {
                    array[column] += matrix[down][column];
                }
                maxSum = Math.max(largestSum(array), maxSum);
            }
        }
        return maxSum;
    }

    public int largestSum(int[] array) {
        int n = array.length;
        int maxSum = array[0];
        int curMax = array[0];
        for (int i = 1; i < n; i++) {
            curMax = Math.max(curMax + array[i], array[i]);
            maxSum = Math.max(curMax, maxSum);
        }
        return maxSum;
    }
}
