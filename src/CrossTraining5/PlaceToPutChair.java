package CrossTraining5;


import java.util.*;

public class PlaceToPutChair {
    public List<Integer> putChair(char[][] gym) {
        int[][] dis = new int[gym.length][gym[0].length];
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == 'E') {
                    boolean[][] visited =  new boolean[gym.length][gym[0].length];
                    bfs(dis, gym, visited, i, j);
                }
            }
        }
        Integer[] ret = new Integer[2];
        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis[0].length; j++) {
                if (dis[i][j] < globalMin && gym[i][j] == 'C') {
                    globalMin = dis[i][j];
                    ret = new Integer[] {i, j};
                }
            }
        }
        if (ret[0] == null) {
            return Arrays.asList(new Integer[] {-1, -1});
        } else {
            return Arrays.asList(ret);
        }

    }

    //dis is the total distance from a point to every equipments
    private void bfs(int[][] dis, char[][] gym, boolean[][] visited, int row, int col) {
        Deque<int[]> queue = new LinkedList<>();  //初始化队列
        queue.offer(new int[] {row, col});
        visited[row][col] = true;
        int d = 0;  //第一层的距离
        int[][] dir = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //四个方向
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int num = 0; num < size; num++) {
                int[] cur = queue.poll();      //当前节点
                dis[cur[0]][cur[1]] += d;      //设置距离
                for (int i = 0; i < 4; i++) {
                    int[] next = new int[] {cur[0] + dir[i][0], cur[1] + dir[i][1]};  //邻居
                    if (next[0] >= 0 && next[0] < gym.length && next[1] >= 0 && next[1] < gym[0].length
                            && !visited[next[0]][next[1]] && gym[next[0]][next[1]] != 'O') {
                        queue.offer(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
            d++;   //下一层
        }
    }

}
