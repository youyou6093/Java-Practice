package class23CrossTraining1;



public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        if (array.length == 1) {
            return new int[] {array[0], array[0]};
        }

        for (int i = 0; i < array.length / 2; i++) {
            //左小右大
            if (array[i * 2] > array[i * 2 + 1]) {
                swap(array, i * 2, i * 2 + 1);
            }
        }
        int minimum = array[0];
        int maximum = array[1];
        for(int i = 0; i < array.length / 2; i++) {
            if (array[i * 2] < minimum) {
                minimum = array[i * 2];
            }
            if (array[i * 2 + 1] > maximum) {
                maximum = array[i * 2 + 1];
            }
        }
        if (array.length % 2 == 0) {
            return new int[] {maximum, minimum};
        } else {
            return new int[] {Math.max(maximum, array[array.length - 1]), Math.min(minimum, array[array.length - 1])};
        }

    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
