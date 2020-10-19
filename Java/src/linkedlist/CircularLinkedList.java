/**
 * 双向循环链表
 * 
 * 特点：
 *  相比单链表，判空时由P.next == null 变成P.next == header;
 * 1. 判空： isEmpty()
 *  return header.next = header;
 */

public class CircularLinkedList<T> {
    
    private Node<T> header;
    public CircularLinkedList() {
        header = new Node<>();
        header.next = header;
    }

    // 判空
    public boolean isEmpty() {
        return header.next == header;
    }

    // 查找元素：
    public Node<T> findNodeByEle(T t) {
        Node<T> p = header.next;
        while(p != header && p.data != t) {
            p = p.next;
        }
        return p;
    }
    
    private class Node<T> {
        Node<T> next;
        T data;
        public Node() {
            this.next = null;
        }
    }

}
