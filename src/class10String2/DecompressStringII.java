package class10String2;

//checked
public class DecompressStringII {
    public String decompress(String input) {
        StringBuilder out = new StringBuilder();
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i++];
            int count = array[i] - '0';
            for (int c = 0; c < count; c++) {
                out.append(ch);
            }
        }
        return out.toString();
    }


    private boolean isNumber(char a) {
        return a - '0' >= 0 && a - '0' <= 9;
    }


    public String decompress2(String input) {
        if (input.isEmpty()) {
           return input;
        }
        char[] array = input.toCharArray();
        return decodeLong(array, decodeShort(array));
    }


    //decode a0 a1 and a2, return the length
    private int decodeShort(char[] input) {
        int end = 0;
        for (int i = 0; i < input.length; i+=2) {
            int digit = input[i + 1] - '0';
            if (digit >= 0 && digit <= 2) {
                for (int j = 0; j < digit; j++) {
                    input[end++] = input[i];
                }
            } else {
                input[end++] = input[i];
                input[end++] = input[i + 1];
            }
        }
        //end is the first undertermined position
        return end;
    }

    //decode a3 a4 a5;
    private String decodeLong(char[] input, int length) {
        int newLength = length;
        for (int i = 0; i < length; i++) {
            int digit = input[i] - '0';
            if (digit > 2 && digit <= 9) {
                newLength += digit - 2;
            }
        }
        char[] ret = new char[newLength];
        int end = newLength - 1;
        for (int i = length - 1; i >=0; i--) {
            int digit = input[i] - '0';
            if (digit > 2 && digit <= 9) {
                i--;
                for (int j = 0; j < digit; j++) {
                    ret[end--] = input[i];
                }
            } else {
                ret[end--] = input[i];
            }
        }
        return new String(ret);
    }
}
