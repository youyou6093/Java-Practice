package class3stackqueuelinkedlist;

import linkedlist.ListNode;

public class MiddleNodeOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // Write your solution here
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}