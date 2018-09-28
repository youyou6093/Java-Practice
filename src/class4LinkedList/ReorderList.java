package class4LinkedList;
import linkedlist.ListNode;

public class ReorderList {
    public ListNode reorder(ListNode head) {
        // Write your solution here
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode mid = findMiddle(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode head2 = reverse(temp);
        ListNode cur = dummy;
        while (head2 != null) {
            cur.next = head;
            cur = cur.next;
            head = head.next;
            cur.next = head2;
            cur = cur.next;
            head2 = head2.next;
        }
        cur.next = head;
        return dummy.next;
    }


    public ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
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
