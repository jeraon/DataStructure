
/**
 * 基于链表实现的栈（很easy）
 * 
 * 1.入栈
 * 2.出栈
 * 3.返回栈顶元素
 * 4.判断栈是否为空
 */
public class ListStack<T> {
    
    private Node<T> header; // 头节点

    public ListStack() {
        header = new Node<T>();
    }

    /**
     * 入栈
     * 将入栈元素节点作为头结点的后继节点
     * @param t
     */
    public void push(T t) {
        Node<T> node = new Node<T>();
        node.data = t;
        node.next = header.next;
        header.next = node;
    }

    /**
     * 出栈
     * 弹出最顶层的节点
     * @return
     */
    public T pop() {
        Node<T> tempNode = header.next;
        header.next = tempNode.next;
        return tempNode.data;
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public T top() {
        return header.next.data;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return header.next == null;
    }

    /**
     * 节点
     */
    static class Node<T> {
        Node<T> next;
        T data;
    }
}
