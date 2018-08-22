import java.util.*;

public class SortingTester {
    public static void main(String [] args){
        int[] x = {3,5,1,2,4,8};
        SelectionSort select = new SelectionSort();
        QuickSort quick = new QuickSort();
        MergeSort merge = new MergeSort();
//        quick.quickSort(x);
//        select.selectSort(x);
        merge.mergeSort(x);
        System.out.println(Arrays.toString(x));
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println();
    }



}
