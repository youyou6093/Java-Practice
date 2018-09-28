package class13Bit;

//CHECKED
public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        int[] set = new int[8];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int row = c / 32;
            int column = c % 32;
            if ((set[row] >> column & 1) != 0) {
                return false;
            } else {
                set[row] |= (1 << column);
            }
        }
        return true;
    }
}
