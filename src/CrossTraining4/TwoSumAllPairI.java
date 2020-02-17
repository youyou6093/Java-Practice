package CrossTraining4;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], new ArrayList<>());
        }
        for (int i = 0; i < array.length; i++) {
            List<Integer> values = map.get(target - array[i]);
            if (values != null) {
                for (int j = 0; j < values.size(); j++) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(values.get(j));
                    sol.add(i);
                    ret.add(sol);
                }
            }
            map.get(array[i]).add(i);
        }
        return ret;

    }
}
