package CrossTraining7;


import java.util.Random;

public class GenerateRandomMaze {
    public static void main(String[] args) {
        GenerateRandomMaze test = new GenerateRandomMaze();
        int[][] ret = test.maze(5);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int[][] maze(int n) {
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = 1;
            }
        }
        maze[0][0] = 0;
        dfs(maze, 0, 0);
        return maze;
    }

    private void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = (int) (Math.random() * (array.length - i)) + i;
            swap(array, index, i);
        }
        return;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public void dfs(int[][] maze, int row, int col) {
        int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] order = new int[] {0, 1, 2, 3};
        shuffle(order);
        for (int i = 0; i < 4; i++) {
            int[] dir = move[order[i]];
            int newRow = row + 2 * dir[0];
            int newCol = col + 2 * dir[1];
            if (newRow < maze.length && newCol < maze[0].length && newRow >= 0 && newCol >= 0
                && maze[newRow][newCol] == 1) {
                maze[newRow - dir[0]][newCol - dir[1]] = 0;
                maze[newRow][newCol] = 0;
                dfs(maze, newRow, newCol);
            }
        }
    }
}
