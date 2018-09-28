package class4LinkedList;
import linkedlist.ListNode;

public class MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        // Write your solution here
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        cur.next = one != null ? one : two;
        return dummy.next;
    }
}