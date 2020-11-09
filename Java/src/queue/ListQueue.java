public class ListQueue<T> {
    
    private Node<T> front;
    private Node<T> rear;

    public ListQueue() {
        front = new Node<T>();
        rear = new Node<T>();
    }

    /**
     * 入队,在队尾节点上追加
     * @param t
     */
    public void enqueue(T t) {
        Node<T> node = new Node<T>();
        node.data = t;
        //空队列时
        if (isEmpty()) {
            front.next = node;
            rear.next = node;
        } else {
            // 队尾节点
            Node<T> temp = rear.next;
            temp.next = node;
            rear.next = node;
        }
    }

    /**
     * 出队，弹出队头第一个节点
     * @return
     */
    public T dequeue() {
        if (!isEmpty()) {
            Node<T> temp = front.next;
            front.next = front.next.next;
            return temp.data;
        }
        return null;
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return front.next == null && rear.next == null;
    }


    /**
     * 打印
     */
    public void printQueue() {
        Node<T> p = front.next;
        while(p != null) {
            System.out.print(p.data +"->");
            p = p.next;
        }
        System.out.println();
    }

    static class Node<T> {
        Node<T> next;
        T data;
    }
}
