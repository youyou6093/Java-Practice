package class8hashtablestring1;



//checked
public class RemoveAdjacentRepeatedChrs {
    public String deDup(String input) {
        char[] array = input.toCharArray();
        int i = 0, j = 0;
        while (j < array.length) {
            if (i > 0 && array[j] == array[i - 1]) {
                j++;
            } else {
                array[i] = array[j];
                i++;
                j++;
            }
        }
        return new String(array, 0, i);
    }
}
