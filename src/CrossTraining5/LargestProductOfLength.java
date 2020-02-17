package CrossTraining5;


import java.lang.reflect.Array;
import java.util.*;

public class LargestProductOfLength {
    static class Comp implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[2] == b[2]) {
                return 0;
            } else {
                return a[2] < b[2] ? 1 : -1;
            }
        }
    }
    public int largestProduct(String[] dict) {
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return 0;
                } else {
                    return o1.length() < o2.length() ? 1 : -1;
                }
            }
        });
        Queue<int[]> pq = new PriorityQueue<>(11, new Comp());
        pq.offer(new int[] {0, 1, dict[0].length() * dict[1].length()});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!containsDup(dict, cur[0], cur[1])) {
                return cur[2];
            }
            if (cur[0] + 1 < dict.length)
                pq.offer(new int[] {cur[0] + 1, cur[1], dict[cur[0] + 1].length() * dict[cur[1]].length()});
            if (cur[1] + 1 < dict.length)
                pq.offer(new int[] {cur[0], cur[1] + 1, dict[cur[0]].length() * dict[cur[1] + 1].length()});
        }
        return 0;
    }

    public boolean containsDup(String[] dict, int x, int y) {
        String a = dict[x], b = dict[y];
        if (a.length() == 0 || b.length() == 0) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < b.length(); i++) {
            set.add(b.charAt(i));
        }
        for (int i = 0; i < a.length(); i++) {
            if (set.contains(a.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
