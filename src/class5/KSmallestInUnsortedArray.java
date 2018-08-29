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
        select(ret, array, 0, array.length - 1, 0, k);
        Arrays.sort(ret);
        return ret;
    }

    public void select(int[] ret, int[] array, int left, int right, int pos, int k) {
        if (k == 0) {
            return;
        }
        if (left == right) {
            ret[pos++] = array[left];
            return;
        }
        if (left >= right) {
            return;
        }
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
        if (pivot - left + 1 <= k) {
            for (int index = left; index <= pivot; index++) {
                ret[pos++] = array[index];
            }
            select(ret, array, pivot + 1, right, pos , k - (pivot - left + 1));
        } else {
            select(ret, array, left, pivot, pos, k);
        }

    }


    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
