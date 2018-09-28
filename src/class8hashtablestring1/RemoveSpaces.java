package class8hashtablestring1;

//checked
//can be optimized use for loop
public class RemoveSpaces {
    public String removeSpaces(String input) {
        char[] array = input.toCharArray();
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (array[j] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                j++;
            } else {
                array[i] = array[j];
                i++;
                j++;
            }
        }
        if ( i > 0 && array[i - 1] == ' ' ) {
            i--;
        }
        return new String(array, 0, i);
    }
}
