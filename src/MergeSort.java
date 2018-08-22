public class MergeSort {
    public void mergeSort(int[] array){
        if (array == null) {
            return;
        }
        mergeSortHelper(array, 0, array.length - 1);
    }

    public void mergeSortHelper(int[] array, int l, int r){
        if (l >= r) {
            return;
        }
        int m = l + (r - l) /2;
        mergeSortHelper(array, l, m);
        mergeSortHelper(array, m + 1, r);
        merge(array, l, m, m + 1, r);
    }

    public void merge(int[] array, int l1, int r1, int l2, int r2){
        int[] leftArray = new int[r1 - l1 + 1];
        for (int i = l1; i <= r1; i++) {
            leftArray[i-l1] = array[i];
        }
        int lPointer = 0, rPointer = l2, arrayPointer = l1;
        while (lPointer <  leftArray.length && rPointer <= r2) {
            if (leftArray[lPointer] <= array[rPointer]) {
                array[arrayPointer++] = leftArray[lPointer++];
            } else {
                array[arrayPointer++] = array[rPointer++];
            }
        }
        if (rPointer > r2) {
            for(int i = arrayPointer; i <= r2; i++){
                array[i] = leftArray[lPointer++];
            }
        }

    }


}
