package linkedlist;

public class StackFromList {
    private ListNode head = null;

    public void push(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        } else {
            int ret = head.value;
            head = head.next;
            return ret;
        }
    }

    public Integer peek() {
        if (head == null) {
            return null;
        } else {
            return head.value;
        }
    }




}
