package class4LinkedList;
import linkedlist.ListNode;

public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        // Write your solution here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.value < value) {
            pre = pre.next;
            head = head.next;
        }
        pre.next = new ListNode(value);
        pre.next.next = head;
        return dummy.next;
    }
}
