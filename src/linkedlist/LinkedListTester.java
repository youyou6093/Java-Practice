package linkedlist;
import class4LinkedList.ReverseLinkedList;

public class LinkedListTester {
    public static void main(String[] args) {
        int[] x = {3,5,1,2,4,8};
        ListNode xList = SingleLinkedList.generateList(x);
        printList(xList);
        ReverseLinkedList tester = new ReverseLinkedList();
        printList(tester.reverse(xList));


    }

    public static void printList (ListNode head){
        int length = 0;
        while (head != null && length < 10000) {
            System.out.print(head.value + " ");
            length++;
            head = head.next;
        }
        System.out.println();
    }

}
