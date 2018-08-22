public class DataStructureTest {
    public static void main (String[] args) {
        testStack();
        testQueue();
        testQueue2();

    }

    public static void testStack() {
        StackFromList stack = new StackFromList();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        while (stack.peek() != null) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

    }

    public static void testQueue() {
        QueueFromList queue = new QueueFromList();
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }
        while (queue.peek() != null) {
            System.out.print(queue.pop() + " ");
        }
        System.out.println();
    }

    public static void testQueue2() {
        QueueFromArray queue = new QueueFromArray();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
            System.out.print(queue.pop() + " ");
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            queue.push(i);
            if (i  % 7 == 0 && i != 0) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(queue.pop() + " ");
                }
            }
        }
    }
}
