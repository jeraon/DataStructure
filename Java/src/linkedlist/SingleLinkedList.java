package datastructure;

public class SingleLinkedList<T> {

    // head pointer
    private Node<T> header;
    private int size;
    SingleLinkedList() {
        header = new Node<T>();
        size = 0;
    }
    
    // 判断是否为空
    public boolean isEmpty() {
        return header.next == null && size == 0;
    }

    // 根据值查找对应node
    private Node<T> findPreNodeByEle(T t) {
        Node<T> p = header;
        if (t == null) {
            return null;
        }

        while (p.next != null && !p.next.data.equals(t)) {
            p = p.next;
        }
        return p;
    }

    private Node<T> findPreNodeByIndex(int index) {
        if(isEmpty() || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p = header;
        int i = 0;
        while (p.next != null && i++ != index) {
            p = p.next;
        }
        return p;
    }

    // 查找尾节点
    private Node<T> findlastNode() {
        Node<T> p = header;
        while(p.next != null) {
            p = p.next;
        }
        return p;
    }

    // 删除第一次出现的给定的对象
    public boolean delete(T t) {
        // step1.找到该元素对应的节点
        Node<T> preNode = findPreNodeByEle(t);
        if (preNode != null) {
            Node<T> cur = preNode.next;
            if(cur == null) {
                throw new IndexOutOfBoundsException();
            }
            preNode.next = cur.next;
            cur = null;
            size --;
            return true;
        }
        return false;
    }

    // 删除给定索引位置的对象
    public T delete(int index) {
        Node<T> preNode = findPreNodeByIndex(index);
        if (preNode != null) {
            Node<T> cur = preNode.next;
            T t = cur.data;
            preNode.next = cur.next;
            cur = null;
            size --;
            return t;
        }
        return null;
    }

    // 添加元素到表尾
    public boolean add(T t) {
        Node<T> node = new Node<T>();
        Node<T> last = findlastNode();
        last.next = node;
        node.data = t;
        size ++;
        return true;
    }

    // 添加元素到指定位置
    public boolean add(T t, int index) {
        Node<T> preNode = findPreNodeByIndex(index);
        Node<T> node = new Node<>();
        node.data = t;
        node.next = preNode.next;
        preNode.next = node;
        size ++;
        return true;
    }

    // 获取指定位置元素
    public T get(int index) {
        Node<T> preNode = findPreNodeByIndex(index);
        if (preNode != null) {
            return preNode.next.data;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Node<T> p = header.next; p != null; p = p.next) {
            builder.append(p.data);
            builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

    private class Node<T> {
        Node<T> next;
        T data;
        public Node() {
            this.next = null;
        } 
    }
}