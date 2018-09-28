package class12Recursion2;
//checked

import java.util.*;

public class SpiralOrderTraversal1 {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        helper(ret, matrix, 0, matrix.length);
        return ret;
    }


    public void helper(List<Integer> ret, int[][] matrix, int start, int size) {
        if (size == 0 || size == 1) {
            if (size == 1) {
                ret.add(matrix[start][start]);
            }
            return;
        }
        for (int i = start; i < start + size - 1; i++) {
            ret.add(matrix[start][i]);
        }
        for (int i = start; i < start + size - 1; i++) {
            ret.add(matrix[i][start + size - 1]);
        }
        for (int i = start + size - 1; i > start; i--) {
            ret.add(matrix[start + size - 1][i]);
        }
        for (int i = start + size - 1; i > start; i--) {
            ret.add(matrix[i][start]);
        }
        helper(ret, matrix, start + 1, size - 2);
    }

}
