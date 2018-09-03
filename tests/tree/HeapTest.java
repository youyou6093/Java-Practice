package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    @Test
    void generalTest() {
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

    @Test
    void testHeapfiy() {
        Integer[] testArray = {7,5,4,2,1,8,9};
        Heap testHeap = new Heap(testArray);
        testHeap.printHeap();
    }

    @Test
    void printHeap() {
    }

    @Test
    void insert() {
    }

    @Test
    void top() {
    }

    @Test
    void pop() {
    }

    @Test
    void percolateUp() {
    }

    @Test
    void percolateDown() {
    }

    @Test
    void swap() {
    }
}