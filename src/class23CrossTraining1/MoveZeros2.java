package class23CrossTraining1;



public class MoveZeros2 {
    public int[] moveZero(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                swap(array, i, index++);
            }
        }
        for (int i = index; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
