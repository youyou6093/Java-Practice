package tree;
import org.omg.CORBA.MARSHAL;

import java.util.*;

//using array to represent heap
//indexOfLc = index * 2 + 1;
//indexOfRc = index * 2 + 2;
//indexOfParent = (index - 1) / 2;

public class Heap {
    private List<Integer> array;
    private int size = 0;
    public Heap(int capacity) {
        array = new ArrayList<>(capacity);
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    public void insert(int e) {
        array.add(e);
        size++;
        percolateUp(size - 1);

    }

    public Integer top () {
        if (size == 0) {
            return null;
        }
        return array.get(0);
    }

    public Integer pop() {
        if (size == 0) {
            return null;
        }
        Integer ret = array.get(0);
        array.set(0, array.get(size - 1));
        size--;
        percolateDown(0);
        return ret;
    }

    public void percolateUp(int cur) {
        while (cur >= 1) {
            int parent = (cur - 1) / 2;
            if (array.get(cur) < array.get(parent)) {
                swap(cur, parent);
                cur = parent;
            } else {
                break;
            }
        }
    }


    public void percolateDown(int cur) {
        while (cur * 2 + 1 < size) {
            int lc = cur * 2 + 1;
            int rc = cur * 2 + 2;
            int lValue = array.get(lc);
            int rValue = rc >= size ? Integer.MAX_VALUE : array.get(rc);
            if (array.get(cur) > Math.min(lValue, rValue)) {
                int next = lValue <= rValue ? lc : rc;
                swap(cur, next);
                cur = next;
            } else {
                break;
            }
        }
    }



    public void swap (int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
