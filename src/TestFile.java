import java.util.*;
import tree.*;

public class TestFile {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it1 = list.iterator();
        Iterator<Integer> it2 = it1;
        it1.next();
//        it1.remove();

        System.out.println(it2.next());
        System.out.println(list.get(0));
    }

}







