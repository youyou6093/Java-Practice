import java.util.*;

public class CombinationsForTelephonePad1 {
    public String[] combinations(int number) {
        HashMap<Character, String> pad = new HashMap<>();
        pad.put('0', "");
        pad.put('1', "");
        pad.put('2', "abc");
        pad.put('3', "def");
        pad.put('4', "ghi");
        pad.put('5', "jkl");
        pad.put('6', "mno");
        pad.put('7', "pqrs");
        pad.put('8', "tuv");
        pad.put('9', "wxyz");
        List<String> ret = new ArrayList<>();
        StringBuilder sol = new StringBuilder();
        String input = Integer.toString(number);
        generate(ret, sol, 0, input, pad);
        return ret.toArray(new String[0]);
    }

    private void generate(List<String> ret, StringBuilder sol, int pos, String input, HashMap<Character, String> pad) {
        if (pos == input.length()) {
            ret.add(sol.toString());
            return;
        }
        String choice = pad.get(input.charAt(pos));
        if (choice.length() == 0) {
            generate(ret, sol, pos + 1, input, pad);
        } else {
            for (int i = 0; i < choice.length(); i++) {
                sol.append(choice.charAt(i));
                generate(ret, sol, pos + 1, input, pad);
                sol.deleteCharAt(sol.length() - 1);
            }
        }
    }
}
