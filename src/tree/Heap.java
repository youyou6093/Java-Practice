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

    public Heap(Integer[] input) {
        array = new ArrayList<Integer>(Arrays.asList(input));
        size = array.size();
        heapify();
    }


    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    public void update(int index, int val) {

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


    private void heapify() {
        heapifyHelp(0);
    }

    private void heapifyHelp(int index) {
        if (index >= size ) {
            return;
        }
        int lc = leftChild(index);
        int rc = rightChild(index);
        heapifyHelp(lc);
        heapifyHelp(rc);
        percolateDown(index);
    }

    private void percolateUp(int cur) {
        while (cur > 0) {
            int pa = parent(cur);
            if (array.get(cur) < array.get(pa)) {
                swap(cur, pa);
                cur = pa;
            } else {
                break;
            }
        }
    }


    private void percolateDown(int cur) {
        while (leftChild(cur) < size) {
            int lc = leftChild(cur);
            int rc = rightChild(cur);
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



    private void swap (int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

}
