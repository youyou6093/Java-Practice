package class24CrossTraining2;

import linkedlist.ListNode;
import java.util.*;

class Comp implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b) {
        if (a.value == b.value) {
            return 0;
        } else {
            return a.value < b.value ? -1 : 1;
        }
    }
}


public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comp());
        for (ListNode node : listOfLists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
            ListNode curNode = pq.poll();
            cur.next = curNode;
            cur = cur.next;
            curNode = curNode.next;
            if (curNode != null) {
                pq.offer(curNode);
            }
        }
        cur.next = null;       //not necessary
        return dummy.next;
    }
}
