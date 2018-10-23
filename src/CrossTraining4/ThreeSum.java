package CrossTraining4;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] == array[i - 1]) continue;
            twoSum(ret, array, target, array[i], i + 1);
        }
        return ret;
    }

    public void twoSum(List<List<Integer>> ret, int[] array, int target, int num, int pos) {
        int t = target - num;
        int left = pos;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] < t) {
                left++;
            } else if (array[left] + array[right] > t) {
                right--;
            } else {
                Integer[] sol = new Integer[] {num, array[left], array[right]};
                ret.add(Arrays.asList(sol));
                while (left + 1 < array.length && array[left + 1] == array[left]) {
                    left++;
                }
                left++;
                while (right - 1 >= 0 && array[right - 1] == array[right]) {
                    right--;
                }
                right--;
            }
        }
    }
}

