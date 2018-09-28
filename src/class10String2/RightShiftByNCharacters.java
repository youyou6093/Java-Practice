package class10String2;


//checked
public class RightShiftByNCharacters {
    public String rightShift(String input, int n) {

        char[] array = input.toCharArray();
        if (array.length == 0) {
            return input;
        }
        int shift = n % array.length;
        reverse(array, 0, array.length - shift - 1);
        reverse(array, array.length - shift, array.length - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);


    }



    private void reverse(char[] array, int i , int j) {
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
