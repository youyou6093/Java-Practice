package class4LinkedList;
import linkedlist.*;

public class CheckIfLinkedListIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode tmp = findMiddle(head);
        ListNode mid = tmp.next;
        tmp.next = null;
        mid = reverse(mid);
        while (mid != null) {
            if (mid.value != head.value) {
                return false;
            }
            mid = mid.next;
            head = head.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next!= null && fast.next.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
