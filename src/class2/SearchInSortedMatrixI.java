package class2;

public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;
        int left = 0;
        int right = numOfRows * numOfColumns - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / numOfColumns;
            int column = mid % numOfColumns;
            if (matrix[row][column] < target) {
                left = mid + 1;
            } else if (matrix[row][column] > target) {
                right = mid - 1;
            } else  {
                return new int[] {row, column};
            }
        }
        return new int[] {-1,-1};


    }
}
