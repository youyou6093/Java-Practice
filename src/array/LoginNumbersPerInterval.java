package array;


import java.util.*;

public class LoginNumbersPerInterval {
    static class Comp implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) {
                return 0;
            } else {
                return a[0] < b[0] ? -1 : 1;
            }
        }
    }

    public int[][] sessionNum(int[][] logins) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comp());
        for (int i = 0; i < logins.length; i++) {
            pq.offer(new int[] {logins[i][0], logins[i][1], 1});
        }
        List<int[]> ret = new ArrayList<>();
        int[] sol = pq.poll();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] >= sol[1]) {
                ret.add(sol);
                sol = cur;
            } else {
                if (cur[0] > sol[0]) {
                    ret.add(new int[] {sol[0], cur[0], sol[2]});
                }
                if (cur[1] < sol[1]) {
                    pq.offer(new int[] {cur[1], sol[1], sol[2]});
                } else if (cur[1] > sol[1]) {
                    pq.offer(new int[] {sol[1], cur[1], cur[2]});
                }
                sol = new int[] {cur[0], Math.min(cur[1], sol[1]), sol[2] + cur[2]};
            }
        }
        ret.add(sol);
        int[][] array = new int[ret.size()][3];
        for (int i = 0; i < ret.size(); i++) {
            array[i] = ret.get(i);
        }
        return array;
    }
}


