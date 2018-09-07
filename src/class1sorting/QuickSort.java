package class1sorting;

public class QuickSort {
    public int[] quickSort(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    public void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = left + (int) ((right - left + 1) * Math.random());
        swap(array, pivot, right); //switch pivot to right;
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
        quickSortHelper(array, left, pivot - 1);
        quickSortHelper(array, pivot + 1, right);


    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
