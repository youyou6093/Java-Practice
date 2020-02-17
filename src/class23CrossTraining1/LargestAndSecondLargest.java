package class23CrossTraining1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestAndSecondLargest {
    public int[] largestAndSecond(int[] array) {
        HashMap<Integer, ArrayList<Integer>>  map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], new ArrayList<>());
        }
        int ret1 = helper(map, array, 0, array.length - 1);
        List<Integer> smaller = map.get(ret1);
        int ret2 = smaller.get(0);
        for (int i = 0; i < smaller.size(); i++) {
            if (ret2 < smaller.get(i)) {
                ret2 = smaller.get(i);
            }
        }
        return new int[] {ret1, ret2};

    }

    private int helper(HashMap<Integer, ArrayList<Integer>> map,  int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
        int ret1 = helper(map, array, left, left + (right - left) / 2);
        int ret2 = helper(map, array,left + (right - left) / 2 + 1, right);
        if (ret1 < ret2) {
            map.get(ret2).add(ret1);
            return ret2;
        } else {
            map.get(ret1).add(ret2);
            return ret1;
        }
    }
}
