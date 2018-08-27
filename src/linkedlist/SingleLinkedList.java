package linkedlist;

public class SingleLinkedList {
    public static ListNode generateList(int[] array){
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        for (int i = 0; i < array.length; i++) {
            pre.next = new ListNode(array[i]);
            pre = pre.next;
        }
        return dummy.next;
    }

}
