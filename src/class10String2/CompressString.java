package class10String2;


//checked

public class CompressString {
    public static void main(String[] args) {
        CompressString x  = new CompressString();
        System.out.println(x.compress("abbcccdeeef"));
    }

    public String compress(String input) {
        StringBuilder array = new StringBuilder(input);
        int slow = 0;
        int fast = 0;
        int numberOfSingle = 0;
        while (fast < array.length()) {
            //found number of counts
            char curChar = array.charAt(fast);
            int count = 1;
            while (fast < array.length() - 1 && array.charAt(fast + 1) == curChar) {
                count++;
                fast++;
            }
            fast++;
            //compress
            array.setCharAt(slow++, curChar);
            if (count != 1) {
                String num = Integer.toString(count);
                for (int i = 0; i < num.length(); i++) {
                    array.setCharAt(slow++, num.charAt(i));
                }
            } else {
                numberOfSingle++;
            }
        }

        return array.substring(0, slow);

//        int finalSize = slow + numberOfSingle;
//        if(finalSize > array.length()) {
//            for (int i = 0; i < finalSize - array.length(); i++) {
//                array.append(' ');
//            }
//        }
//        int start = slow - 1;
//        fast = start;
//        slow += numberOfSingle - 1;
//        while (fast >= 0) {
//            if(!isNumber(array.charAt(fast)) && (fast == start || !isNumber(array.charAt(fast + 1)))) {
//                array.setCharAt(slow--, '1');
//                array.setCharAt(slow--, array.charAt(fast--));
//            } else {
//                array.setCharAt(slow--, array.charAt(fast--));
//            }
//        }
//        return array.substring(0, finalSize);



    }

    private boolean isNumber(char a) {
        return a - '0' >= 0 && a - '0' <= 9;
    }
}
