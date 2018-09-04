package linkedlistProblems;

import linkedlist.ListNode;
import java.util.*;

public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here/.
        class Comb{
            int value;
            int index;
            Comb(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
        PriorityQueue<Comb> pq = new PriorityQueue<>(new Comparator<Comb>(){
            public int compare(Comb a, Comb b){
                if (a.value == b.value) {
                    return 0;
                } else {
                    return a.value < b.value ? -1 : 1;
                }
            }
        });
        for (int i = 0; i < listOfLists.size(); i++) {
            pq.offer(new Comb(listOfLists.get(i).value, i));
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
            Comb curSmall = pq.poll();
            ListNode curNode = listOfLists.get(curSmall.index);
            cur.next = curNode;
            cur = cur.next;
            curNode = curNode.next;
            listOfLists.set(curSmall.index, curNode);
            if (curNode != null) {
                pq.offer(new Comb(curNode.value, curSmall.index));
            }
        }
        cur.next = null;
        return dummy.next;
    }
}
