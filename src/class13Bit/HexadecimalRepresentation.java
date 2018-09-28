package class13Bit;

//checked
public class HexadecimalRepresentation {
    public String hex(int number) {
        if (number == 0) {
            return "0x0";
        }
        char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int num = number & 15;
            number >>= 4;
            sb.append(array[num]);
        }
        sb.reverse();

        return "0x" + sb.toString();
    }
}
