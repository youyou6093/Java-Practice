package CrossTraining4;
import java.util.*;

public class TwoSumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        Arrays.sort(array);
        int i = 0, j = array.length - 1;
        List<List<Integer>> ret = new ArrayList<>();
        while (i < j) {
            if (array[i] + array[j] == target) {
                List<Integer> sol = new ArrayList<>();
                sol.add(array[i]);
                sol.add(array[j]);
                ret.add(sol);
                while (i + 1 < j && array[i + 1] == array[i]) i++;
                i++;
                while (j - 1 > i && array[j - 1] == array[j]) j--;
                j--;
            } else if (array[i] + array[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return ret;
    }
}
