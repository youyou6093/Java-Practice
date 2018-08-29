package class5;


import java.util.*;

public class KSmallestInUnsortedArray {
    public static void main (String[] args) {
        int[] array = {1,2,3,4};
        KSmallestInUnsortedArray tester = new KSmallestInUnsortedArray();
        int[] ret = tester.kSmallest(array, 2);
        System.out.println(Arrays.toString(ret));

    }

    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        int[] ret = new int[k];
        if (k == 0) {
            return ret;
        }
        select(array, 0, array.length - 1, k - 1);
        for (int i = 0; i < k; i++) {
            ret[i] = array[i];
        }
        Arrays.sort(ret);
        return ret;
    }

    public void select(int[] array, int left, int right, int target) {

        int pivot = left +  (int) ((right - left + 1) * Math.random());
//        int pivot = left + (right - left) / 2;
        swap(array, pivot, right);
        int i = 0, j = right - 1;
        while (i <= j) {
            if (array[i] <= array[right]) {
                i++;
            } else {
                swap(array, i, j--);
            }
        }
        swap(array, i, right);
        pivot = i;
        if (pivot == target) {
            return;
        } else if (pivot > target) {
            select(array, left, pivot - 1, target);
        } else {
            select(array, pivot + 1, right, target);
        }
    }


    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
