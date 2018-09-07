package class1sorting;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        int[] helperArray = new int[array.length];
        mergeSortHelper(array, 0, array.length - 1, helperArray);
        return array;
    }

    public void mergeSortHelper(int[] array, int left, int right, int[] helperArray) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortHelper(array, left, mid, helperArray);
        mergeSortHelper(array, mid + 1, right, helperArray);
        merge(array, left, mid, mid + 1, right, helperArray);
    }

    public void merge(int[] array, int left1, int right1, int left2, int right2, int[] helperArray) {
        for (int i = left1; i <= right1; i++) {
            helperArray[i] = array[i];
        }
        int i = left1, j = left2, k = left1;
        while (i <= right1 && j <= right2) {
            if (helperArray[i] <= array[j]) {
                array[k++] = helperArray[i++];
            } else {
                array[k++] = array[j++];
            }
        }
        if (j > right2) {
            while (i <= right1) {
                array[k++] = helperArray[i++];
            }
        }


    }
}

