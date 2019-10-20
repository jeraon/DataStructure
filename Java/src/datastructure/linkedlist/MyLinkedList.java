package datastructure.linkedlist;

// 节点
class Node<T> {
    public Node<T> next;
    public T data;
}

public class MyLinkedList<T> {
    // 头节点
    private Node<T> head;

    // 构造方法中创建链表时，就创建一个头节点
    public MyLinkedList() {
        head = new Node<>();
        head.next = null;
    }

    // 创建一个节点
    private Node<T> createNode() {
        Node<T> node = new Node<>();
        node.next = null;
        return node;
    }

    // 添加一个节点到尾部
    public void appendNode(T t) {
        // 1.创建节点
        Node<T> node = createNode();
        node.data = t;
        // 2.寻找尾节点
        Node<T> last = lastNode();
        // 3.插入
        last.next = node;
        node.next = null;
    }

    // 寻找尾节点
    private Node<T> lastNode() {
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    // 插入一个节点到头部
    public void insertToHead(T t) {
        // 1.创建节点
        Node<T> node = new Node<>();
        node.data = t;
        // 2.直接插入到head节点的后面
        node.next = head.next;
        head.next = node;
    }

    // 查询是否存在
    public boolean contain(T t) {
        Node<T> node = find(t);
        // 如果为null，说明没有该元素
        return node != null;
    }

    // 返回给定数的节点
    private Node<T> find(T t) {
        // 因为这里涉及到了node.data，为了避免head也进行取data操作，所以从第一个节点开始遍历，而不是头节点
        Node<T> node = head.next;
        while (node != null && node.data != t) {
            node = node.next;
        }
        return node;
    }

    // 删除给定数的节点
    public void deleteNode(T t) {
        // 1.查找该数的前驱节点
        Node<T> previous = findPreviousNode(t);
        Node<T> currentNode = null;
        if (previous != null) {
            // 当前数据的节点
            currentNode = previous.next;
            previous.next = currentNode.next;
            currentNode = null;
        }
    }

    private Node<T> findPreviousNode(T t) {
        Node<T> node = head;
        while (node.next != null && node.next.data != t) {
            node = node.next;
        }
        // 判断是否是最后一个元素
        if (isLast(node)) {
            return null;
        }
        return node;
    }

    // 判断是否是最后一个节点
    private boolean isLast(Node node) {
        return node.next == null;
    }

    // 判断链表是否为空
    public boolean empty() {
        return head.next == null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
            stringBuilder.append(node.data + ",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
