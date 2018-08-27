package class3;
import linkedlist.ListNode;



public class CheckIfLinkedListHasACycle {
    public boolean hasCycle(ListNode head) {
        // write your solution here
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}