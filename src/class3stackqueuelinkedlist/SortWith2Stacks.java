package class3stackqueuelinkedlist;

import java.util.*;

public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        int size = s1.size();
        for (int i = 0; i < size; i++) {
            int min = s1.peek();
            while(!s1.isEmpty()) {
                if (s1.peek() < min) {
                    min = s1.peek();
                }
                s2.push(s1.pop());
            }
            boolean findMin = false;
            while(s2.size() > i) { //sorted elements so far
                if (s2.peek() == min && !findMin) {
                    findMin = true;
                    s2.pop();
                } else {
                    s1.push(s2.pop());
                }
            }
            s2.push(min);
        }
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}

