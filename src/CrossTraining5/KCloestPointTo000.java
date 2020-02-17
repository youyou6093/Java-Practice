package CrossTraining5;
import java.util.*;



public class KCloestPointTo000 {
    static class Cell {
        int x;
        int y;
        int z;
        int val;
        Cell(int x, int y, int z, int val) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.val = val;
        }

        @Override
        public boolean equals(Object object) {
            Cell obj = (Cell) object;
            return x == obj.x && y == obj.y && z == obj.z;
        }

        @Override
        public int hashCode() {
            return 32 * 32 * x + 32 * y + z;
        }
    }

    static class Comp implements Comparator<Cell> {
        @Override
        public int compare(Cell a, Cell b) {
            if (a.val == b.val) {
                return 0;
            } else {
                return a.val < b.val ? -1 : 1;
            }
        }
    }


    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comp());
        HashSet<Cell> visited = new HashSet<>();
        pq.offer(new Cell(0, 0, 0, a[0] * a[0] + b[0] * b[0] + c[0] * c[0]));  //first point
        int[][] dir = new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        for (int i = 0; i < k - 1; i++) {
            Cell cur = pq.poll();
            for (int j = 0; j < 3; j++) {
                int x = cur.x + dir[j][0];
                int y = cur.y + dir[j][1];
                int z = cur.z + dir[j][2];
                if (x < a.length && y < b.length && z < c.length && visited.add(new Cell(x, y, z,
                        a[x] * a[x] + b[y] * b[y] + c[z] * c[z]))) {
                    pq.offer(new Cell(x, y, z, a[x] * a[x] + b[y] * b[y] + c[z] * c[z]));
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        Cell res = pq.peek();
        ret.add(a[res.x]);
        ret.add(b[res.y]);
        ret.add(c[res.z]);
        return ret;


    }
}



