package CrossTraining7;


import java.util.HashMap;
import java.util.Hashtable;

public class MostPointsOnALine {
    public int most(Point[] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Point cur = points[i];
            int same = 1;
            int sameX = 0;
            int most = 0;
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point tmp = points[j];
                if (tmp.x == cur.x && tmp.y == cur.y) {
                    same++;
                } else if (tmp.x == cur.x) {
                    sameX++;
                } else {
                    double slope = 1.0 * (tmp.y - cur.y) / (tmp.x - cur.x);
                    if (!map.containsKey(slope)) {
                        map.put(slope, 1);
                    } else {
                        map.put(slope, map.get(slope) + 1);
                    }
                    most = Math.max(most, map.get(slope));
                }
            }
            most = Math.max(most, sameX) + same;
            result = Math.max(result, most);
        }
        return result;
    }
}
