package class3stackqueuelinkedlist;
import linkedlist.*;


public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = findMiddle(head);
        ListNode mid = tmp.next;
        tmp.next = null;
        ListNode list1 = mergeSort(head);
        ListNode list2 = mergeSort(mid);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2!= null) {
            if (l1.value <= l2.value) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next!= null && fast.next.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }
}
