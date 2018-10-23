package class24CrossTraining2;
import java.util.*;
class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
      this.value = value;
    }
}

public class DeepCopyLinkedListWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> m = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        while (head != null) {
            if (m.containsKey(head)) {
                cur.next = m.get(head);
            } else {
                cur.next = new RandomListNode(head.value);
                m.put(head, cur.next);
            }
            if (head.random != null) {
                if (m.containsKey(head.random)) {
                    cur.next.random = m.get(head.random);
                } else {
                    cur.next.random = new RandomListNode(head.random.value);
                    m.put(head.random, cur.next.random);
                }
            }
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }
}

