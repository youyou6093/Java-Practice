package class12Recursion2;
import linkedlist.ListNode;

import java.util.List;
//checked
public class ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseInPairs(head.next.next);
        ListNode next = head.next;   //reverse head and head.next
        next.next = head;
        head.next = newHead;
        return next;
    }
}
