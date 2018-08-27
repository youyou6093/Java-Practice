package class3;
import linkedlist.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int target) {
        // Write your solution here
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode tail1 = dummy1, tail2 = dummy2;
        while (head != null) {
            if (head.value < target) {
                tail1.next = head;
                tail1 = tail1.next;
                head = head.next;
            } else {
                tail2.next = head;
                tail2 = tail2.next;
                head = head.next;
            }
        }
        tail2.next = null;
        tail1.next = dummy2.next;
        return dummy1.next;

    }
}
