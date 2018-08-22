public class QuickSort {
    public void quickSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }

        quickHelper(array, 0, array.length - 1);

    }

    public void quickHelper(int[]array, int l, int r){
        if(l >= r){
            return;
        }
        int i = l;
        int j = r - 1;
//        int pivot = l + ((int) Math.random() * (r - l + 1));
        int pivot = (l + r) / 2;
        swap(array, pivot, r);
        while(i <= j){
            if(array[i] <= array[r]){
                i++;
            }else{
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, r);
        quickHelper(array, l ,i - 1);
        quickHelper(array, i + 1, r);
    }

    public void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
