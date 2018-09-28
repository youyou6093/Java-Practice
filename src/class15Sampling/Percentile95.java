package class15Sampling;
import java.util.*;

public class Percentile95 {
    public int percentile95(List<Integer> lengths) {
        int[] array = new int[4097];
        for (int x : lengths) {
            array[x]++;
        }
        int sum = 0;
        int index = 4097;
        while (sum <= 0.05 * lengths.size()) {          //this is pretty important
            sum += array[--index];
        }
        return index;
    }
}
