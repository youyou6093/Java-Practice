package CrossTraining4;


import java.util.ArrayList;
import java.util.List;

public class CommonNumberInThreeSortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;
        List<Integer> ret = new ArrayList<>();
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                ret.add(a[i]);
                i++;
                j++;
                k++;
            } else if (a[i] <= b[j] && a[i] <= c[k]) {
                i++;
            } else if (b[j] <= a[i] && b[j] <= c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return ret;
    }
}
