package class15Sampling;


import java.util.Arrays;

public class PerfectShuffle {
    public void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = (int) (Math.random() * (array.length - i)) + i;
            swap(array, index, i);
        }
        return;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

