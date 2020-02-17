package CrossTraining7;


import java.util.ArrayList;
import java.util.List;

public class LongestAscendingSubSequence {
    public static void main(String[] args) {
        LongestAscendingSubSequence test = new LongestAscendingSubSequence();
        test.longest(new int[] {10,11,1,2,12,3,4});


    }

    public int longest(int[] array) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (res.size() == 0 || array[i] > res.get(res.size() - 1)) {
                res.add(array[i]);
            } else {
                search(res, array[i]);
            }
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

