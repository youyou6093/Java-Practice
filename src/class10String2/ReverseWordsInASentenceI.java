package class10String2;

//checked


public class ReverseWordsInASentenceI {
    public String reverseWords(String input) {
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        int slow = 0, fast = 0;
        while (fast < array.length) {
            if (array[fast] != ' ') {
                if (slow != 0) array[slow++] = ' ';
                int begin = slow;
                //out of loop condition, fast == array.length || array[fast] == ' '
                while (fast < array.length && array[fast] != ' ') {
                    array[slow++] = array[fast++];
                }
                reverse(array, begin, slow - 1);
            } else {
                fast++;
            }
        }
        return new String(array, 0, slow);
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