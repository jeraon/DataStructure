public class Main {
    
    public static void main(String[] args) {
        //testListStack();
        testListQueue();
    }

    private static void testListQueue() {
        ListQueue<String> queue = new ListQueue<>();
        queue.enqueue("Monday");
        queue.enqueue("Tuesday");
        queue.enqueue("Wednesday");
        queue.enqueue("Thursday");

        queue.printQueue();
        
        for(int i=0;i<4;i++) {
            System.out.println(queue.dequeue());
        }
    }

    private static void testListStack() {
        ListStack<Integer> stack = new ListStack<>();
        stack.push(12);
        stack.push(8);
        stack.push(6);
        stack.push(9);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
