package CrossTraining7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class LargestSetOfPointsWithPositiveSlope {
    public int largest(Point[] points) {
        //sort by x
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                if (point.x == t1.x && point.y == t1.y) {
                    return 0;
                } else {
                    if (point.x != t1.x) {
                        return point.x < t1.x ? -1 : 1;
                    } else {
                        return point.y < t1.y ? -1 : 1;
                    }
                }
            }
        });

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (res.size() == 0 || points[i].y > res.get(res.size() - 1)) {
                res.add(points[i].y);
            } else {
                search(res, points[i].y);
            }
        }
        if (res.size() == 1) {
            return 0;
        }
        return res.size();
    }


    public void search(List<Integer> array, int num) {
        if (array.size() == 2) {
            if (array.get(0) >= num) {
                array.set(0, num);
            } else {
                array.set(1, num);
            }
            return;
        }

        int left = 0;
        int right = array.size() - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array.get(mid) < num) {
                left = mid;
            } else if (array.get(mid) > num) {
                right = mid;
            } else {
                array.set(mid, num);
                return;
            }
        }
        array.set(right, num);
    }
}
