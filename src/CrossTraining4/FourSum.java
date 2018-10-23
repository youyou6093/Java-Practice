package CrossTraining4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



public class FourSum {
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int rest = target - array[i] - array[j];
                if (m.containsKey(rest)) {
                    if (i > m.get(rest)) {
                        return true;
                    }
                }
                if (!m.containsKey(array[i] + array[j])) {
                    m.put(array[i] + array[j], j);
                } else {
                    m.put(array[i] + array[j], Math.min(j, m.get(array[i] + array[j])));
                }
            }
        }
        return false;
    }
}
