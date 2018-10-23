package CrossTraining4;
import java.util.*;


public class AllSubsets2 {
    public List<String> subSets(String set) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        StringBuilder sol = new StringBuilder();
        if (set == null) {
            return ret;
        }
        for (int i = 0; i < set.length(); i++) {
            Integer count = map.get(set.charAt(i));
            if (count == null) {
                map.put(set.charAt(i), 1);
            } else {
                map.put(set.charAt(i), count + 1);
            }
        }
        int index = 0;
        char[] array = new char[map.size()];
        for (char c : map.keySet()) array[index++] = c;
        dfs(ret, sol, map, array, 0);
        return ret;
    }

    public void dfs(List<String> ret, StringBuilder sol, HashMap<Character, Integer> map,
                    char[] array, int level) {
        if (level == array.length) {
            ret.add(sol.toString());
            return;
        }
        int size = sol.length();
        for (int i = 0; i <= map.get(array[level]); i++) {
            dfs(ret, sol, map, array, level + 1);
            sol.append(array[level]);
        }
        sol.delete(size, sol.length());
    }
}

