package class10String2;

//checked
public class ReverseString {
    public String reverse(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
        return new String(array);

    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
