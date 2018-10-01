package CrossTraining;


public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix x = new RotateMatrix();
        x.rotate(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }


    public void rotate(int[][] matrix) {
        helper(matrix, 0, matrix.length);
        return;
    }


    public void helper(int[][] matrix, int start, int size) {
        if (size == 0 || size == 1) {
            return;
        }

        for (int i = start; i < start + size - 1; i++) {
            int backup = matrix[start][i];
            int cur = matrix[start][i];
            int[] cord = new int[] {start, i};
            for (int j = 0; j < 4; j++) {
                backup = cur;
                cord = trans(cord[0], cord[1], matrix.length);
                cur = matrix[cord[0]][cord[1]];
                matrix[cord[0]][cord[1]] = backup;
            }
        }
        helper(matrix, start + 1, size - 2);
    }

    public int[] trans(int row, int column, int size) {
        return new int[] {column, size - 1 - row};
    }
}




//row + newColumn = size;
//column = newRow





//1 2 3
//4 5 6
//7 8 9