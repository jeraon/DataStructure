
/**
 * 双向链表
 * 相比单链表的优势：
 *  不需要寻找前驱节点；
 * 缺点：
 *  增加了一个指针域，更加占用内存
 * 
 * 1.追加节点：append(T t)
 *  newNode->next = null;
 *  newNode->pre = lastNode;
 *  lastNode->next = newNode;
 * 
 * 2.删除节点：remove(T t)
 *  curNode->pre->next = curNode->next; //当前节点的前驱指向它的后继
 *  curNode->next->pre = curNode->pre;  //当前节点的后继节点的前驱指向当前节点的前驱
 *  curNode = null;
 * 
 * 3.插入节点：add(int index, T t)
 *  newNode.next = curNode;         // 新节点后继指向当前节点；
 *  newNode.pre = curNode.pre;      // 新节点前驱指向当前节点的前驱
 *  curNode.pre.next = newNode;     // 当前节点前驱的后继指向新节点
 *  curNode.pre = newNode;          // 当前节点前驱指向新节点
 * 
 */
public class DoubleLinkedList<T> {
    
    private Node<T> header;
    private int mSize;
    public DoubleLinkedList() {
        header = new Node<T>();
        mSize = 0;
    }

    // 查找尾节点
    public Node<T> findLastNode() {
        Node<T> p = header;
        while(p.next != null) {
            p = p.next;
        }
        return p;
    }

    public Node<T> findNodeByEle(T t) {
        if (t == null) return null;

        Node<T> p = header.next;
        while(p != null && p.data != t) {
            p = p.next;
        }
        return p;
    }

    // 插入节点
    public boolean add(int index, T t) {
        Node<T> curNode = findNodeByIndex(index);
        Node<T> newNode = new Node<T>();
        newNode.data = t;
        newNode.next = curNode;
        newNode.pre = curNode.pre;
        curNode.pre.next = newNode;
        curNode.pre = newNode;
        mSize++;
        return true;
    }

    private Node<T> findNodeByIndex(int index) {
        if (index >= mSize) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = header.next;
        int i = 0;
        while(node != null && i++ != index) {
            node = node.next;
        }
        return node;
    }

    // 删除节点
    public boolean remove(T t) {
        Node<T> curNode = findNodeByEle(t);
        if (curNode == null) {
            throw new IndexOutOfBoundsException();
        }
            curNode.pre.next = curNode.next;
            curNode.next.pre = curNode.pre;
            curNode = null;
            mSize--;
            return true;
    }

    public boolean append(T t) {
        Node<T> node = new Node<T>();
        node.data = t;
        Node<T> lastNode = findLastNode();
        lastNode.next = node;
        node.pre = lastNode;
        mSize++;
        return true;
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

    class Node<T> {
        public Node<T> next;
        public Node<T> pre;
        T data;
        public Node() {
            next = null;
            pre = null;
        }
    }
 }
