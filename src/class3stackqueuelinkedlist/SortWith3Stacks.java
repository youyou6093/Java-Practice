package class3stackqueuelinkedlist;
import java.util.*;


public class SortWith3Stacks {
    public static void main(String[] args) {
        SortWith3Stacks x = new SortWith3Stacks();
        int[] array = new int[] {5, 1, 4, 9, 8};
        LinkedList<Integer> s = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            s.push(array[i]);
        }
        x.sort(s);
        while (!s.isEmpty()) {
            System.out.print(s.pop() +  " ");
        }

    }

    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        help(s1, s2, s3, s1.size());
        return;
    }

    private void help(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int size) {
        if (size <= 1) return;
        int part1 = size / 2;
        int part2 = size - size / 2;
        for (int i = 0; i < part2; i++) {
            s2.push(s1.pop());
        }
        help(s1, s2, s3, part1); //sort s1
        help(s2, s1, s3, part2); //sort s2
        //s1 has size part1, s2 has size part2
        int i = 0, j = 0;
        while (i < part1 && j < part2) {
            if(s1.peek() <= s2.peek()) {
                s3.push(s1.pop());
                i++;
            } else {
                s3.push(s2.pop());
                j++;
            }
        }
        while (i < part1) {
            s3.push(s1.pop());
            i++;
        }
        while (j < part2) {
            s3.push(s2.pop());
            j++;
        }
        for(i = 0; i < size; i++) {
            s1.push(s3.pop());
        }
    }
}
