package class1;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        int i = 0, j = 0, k = array.length - 1;
        //[0,i) : -1; [i, j) : 0; (k: end) : 1
        while (j <= k) {
            if (array[j] == -1) {
                swap(array, i++, j++);
            } else if (array[j] == 0) {
                j++;
            } else {
                swap(array, j, k--);
            }
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
