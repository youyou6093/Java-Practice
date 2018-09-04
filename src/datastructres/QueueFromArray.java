package datastructres;/* the data range is (head, tail) not included
*  if (head + 1) % size == tail : queue is empty;
*  if head == tail : queue is full
*  capacity is array.length - 1;
*  this version doesn't record size
* */

public class QueueFromArray {
    private Integer[] array;
    private int head, tail;
    public QueueFromArray () {
        array = new Integer[5];
        head = 0;
        tail = 1;

    }

    public boolean isEmpty() {
        return (head + 1) % array.length == tail;
    }

    public void expand() {
        Integer[] newArray = new Integer[array.length * 3 / 2];
        int ptr = 1;
        for (int i = head + 1; i < array.length; i++) {
            newArray[ptr++] = array[i];
        }
        for (int i = 0; i < head; i++) {  //head = tail
            newArray[ptr++] = array[i];
        }
        tail = ptr;
        head = 0;
        array = newArray;
    }

    public void push(int val) {
        array[tail] = val;
        tail = (tail + 1) % array.length;
        if (head == tail) {
            expand();
        }
//        System.out.println("after push new head is " + head + " " + "new tail is " + tail);
    }

    public Integer peek() {
        if (isEmpty() == false) {
            return array[head];
        } else {
            return null;
        }
    }

    public Integer pop() {
        if (isEmpty() == false) {
            head = (head + 1) % array.length;
            Integer ret = array[head];
//            System.out.println("after new head is " + head + " " + "new tail is " + tail);
            return ret;
        } else {
            return null;
        }

    }


}
