package class8hashtablestring1;
import java.util.*;


//checked
public class CommonNumbersOfTwoSortedArray {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here
        List<Integer> ret = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else {
                ret.add(A.get(i));
                i++;
                j++;
            }
        }
        return ret;
    }
}
