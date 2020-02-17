package CrossTraining4;


import java.util.HashSet;

public class TwoSum {
    public boolean existSum(int[] array, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(target - array[i])) {
                return true;
            }
            set.add(array[i]);
        }
        return false;
    }
}
