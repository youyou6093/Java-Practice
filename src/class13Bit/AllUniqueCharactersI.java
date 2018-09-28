package class13Bit;

//CHECKED
public class AllUniqueCharactersI {
    public boolean allUnique(String word) {
        int set = 0;
        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';         //position in the interger
            if ((set >> num & 1) != 0) {
                return false;
            } else {
                set |= (1 << num);
            }
        }
        return true;
    }
}
