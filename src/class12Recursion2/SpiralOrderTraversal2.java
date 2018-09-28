//checked

package class12Recursion2;
import java.util.*;
public class SpiralOrderTraversal2 {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        helper(ret, matrix, 0, rows, columns);
        return ret;
    }

    public void helper(List<Integer> ret, int[][] matrix, int start, int rowSize, int columnSize) {
        if (rowSize == 0 || columnSize == 0) {
            return;
        }
        if (rowSize == 1 || columnSize == 1) {
            //add one row
            if (columnSize >= rowSize) {
                for (int i = start; i < start + columnSize; i++) {
                    ret.add(matrix[start][i]);
                }
            } else {
                //add one column
                for (int i = start; i < start + rowSize; i++) {
                    ret.add(matrix[i][start]);
                }
            }
            return;
        }
        //column
        for (int i = start; i < start + columnSize - 1; i++) {
            ret.add(matrix[start][i]);
        }
        //row
        for (int i = start; i< start + rowSize - 1; i++) {
            ret.add(matrix[i][start + columnSize - 1]);
        }
        //column
        for (int i = start + columnSize - 1; i > start; i--) {
            ret.add(matrix[start + rowSize - 1][i]);
        }
        //row
        for (int i = start + rowSize - 1; i > start; i--) {
            ret.add(matrix[i][start]);
        }
        helper(ret, matrix, start + 1, rowSize - 2, columnSize - 2);

    }
}
