package class10String2;

//checked
public class ReorderArray {
    public int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            helper(array, 0, array.length - 1);
        } else {
            helper(array, 0, array.length - 2);
        }
        return array;
    }

    private void helper(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size <= 2) {
            return;
        }
        int mid = left + size / 2;
        int lm =  left + size / 4;
        int rm =  mid + size / 4;
        reverse(array, lm, mid - 1);
        reverse(array, mid, rm - 1);
        reverse(array, lm, rm - 1);
        helper(array, left , left + 2 * (size / 4) - 1);
        helper(array, left + 2 * (size / 4), right);
    }


    private void reverse(int[] array, int i , int j) {
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
