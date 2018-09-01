

import java.util.*;

class WallsAndGates {
    class Cell{
        int x;
        int y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return rooms;
        }
        int rows = rooms.length;
        int columns = rooms[0].length;
        Queue<Cell> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <columns; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Cell(i, j));
                }
            }
        }
        bfs(queue, rooms, new boolean[rows][columns], rows, columns);
        return rooms;

    }

    public void bfs(Queue<Cell> queue, int[][] rooms, boolean[][] visited, int rows, int columns) {
        int[][] move = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = move[i][0] + cur.x;
                int newY = move[i][1] + cur.y;
                if (newX >= 0 && newX < rows && newY >= 0 && newY < columns &&
                        !visited[newX][newY] && rooms[newX][newY] != -1 && rooms[newX][newY] != 0) {
                    queue.offer(new Cell(newX, newY));
                    rooms[newX][newY] = Math.min(rooms[newX][newY], rooms[cur.x][cur.y] + 1);
                    visited[newX][newY] = true;
                }
            }
        }
    }
}