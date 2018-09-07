package class3stackqueuelinkedlist;
import java.util.*;

public class SortWith3Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        while (!s1.isEmpty()) {
            int min = s1.peek();
            while (!s1.isEmpty()) {
                if (s1.peek() < min) {
                    min = s1.peek();
                }
                s2.push(s1.pop());
            }
            while (!s2.isEmpty()) {
                if (s2.peek() == min) {
                    s3.push(s2.pop());
                } else {
                    s1.push(s2.pop());
                }
            }
        }
        while (!s3.isEmpty()) {
            s1.push(s3.pop());
        }
    }
}
