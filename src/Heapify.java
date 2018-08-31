
public class Heapify {
    public int[] heapify(int[] array) {
        // Write your solution here
        if (array == null) {
            return array;
        }
        helper(array, 0);
        return array;


    }

    public void helper(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        int lc = leftChild(index);
        int rc = rightChild(index);
        helper(array, lc);
        helper(array, rc);
        percolateDown(array, index);
    }



    public void percolateDown(int[] array, int cur) {
        int lc = leftChild(cur);
        int rc = rightChild(cur);
        if (lc >= array.length) {
            return;
        }
        int lValue = array[lc];
        int rValue = rc >= array.length ? Integer.MAX_VALUE : array[rc];
        if (array[cur] > Math.min(lValue, rValue)) {
            int next = lValue <= rValue ? lc : rc;
            swap (array, cur, next);
            percolateDown(array, next);
        } else {
            return;
        }
    }


    public void swap(int[] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void percolateDownIteration(int[] array, int cur) {
        while (leftChild(cur) < array.length) {
            int lc = leftChild(cur);
            int rc = rightChild(cur);
            int lValue = array[lc];
            int rValue = rc >= array.length ? Integer.MAX_VALUE : array[rc];
            if (array[cur] > Math.min(lValue, rValue)) {
                int next = lValue <= rValue ? lc : rc;
                swap (array, cur, next);
                cur = next;
            } else {
                break;
            }
        }
    }
}
