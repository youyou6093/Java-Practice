package class7hashtablestring1;

public class MissingNumber1 {
    public int missing(int[] array) {
        int num = 0;
        int n = array.length + 1;
        for (int i = 1; i <= n; i++) {
            num ^= i;
        }
        for (int i = 0; i < array.length; i++) {
            num ^= array[i];
        }
        return num;
    }
}
