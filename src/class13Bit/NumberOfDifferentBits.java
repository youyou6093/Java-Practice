package class13Bit;

//checked
public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        int count = 0;
        int x = a ^ b;
        while (x != 0) {
            count += (x & 1);
            x = x >>> 1;
        }
        return count;
    }
}
