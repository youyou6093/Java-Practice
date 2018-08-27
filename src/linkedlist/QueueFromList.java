package linkedlist;

public class QueueFromList {
    private ListNode head;
    private ListNode tail;

    public void push(int value) {
        if (head == null) {
            head = new ListNode(value);
            tail = head;
        } else {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
    }

    public Integer peek() {
        if (head == null) {
            return null;
        } else {
            return head.value;
        }
    }

    public Integer pop() {
        if (head == null) {
            return null;
        } else {
            Integer ret = head.value;
            head = head.next;
            return ret;
        }
    }
}
