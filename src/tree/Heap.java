package tree;
import java.util.*;

//using array to represent heap
//indexOfLc = index * 2 + 1;
//indexOfRc = index * 2 + 2;
//indexOfParent = (index - 1) / 2;

public class Heap {
    public static void main(String[] args) {
        int[] testArray = {7,5,4,2,1,8,9};
        Heap testHeap = new Heap(1);
        for (int i = 0; i < testArray.length; i++) {
            testHeap.insert(testArray[i]);
            testHeap.printHeap();
        }
        for (int i = 0; i < testArray.length; i++) {
            testHeap.pop();
            testHeap.printHeap();
        }
    }


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
//        System.out.println(Arrays.toString(array.toArray()));
    }

    //percolate up
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
            if (rc > size) {
                if (array.get(lc) < array.get(cur)) {
                    swap(lc, cur);
                    cur = lc;
                } else {
                    break;
                }
            } else {
                if (array.get(cur) > Math.min(array.get(lc), array.get(rc))) {
                    int nextIndex = array.get(lc) <= array.get(rc) ? lc : rc;
                    swap(nextIndex,cur);
                    cur = nextIndex;
                } else {
                    break;
                }
            }
        }
    }



    public void swap (int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
