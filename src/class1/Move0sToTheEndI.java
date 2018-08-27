package class1;


public class Move0sToTheEndI {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        int i = 0, j = array.length - 1;
        while (i <= j) {
            if (array[i] == 0) {
                swap(array, j--, i);
            } else {
                i++;
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
