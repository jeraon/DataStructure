package datastructure.linkedlist;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.insertToHead(4);
        myLinkedList.insertToHead(10);
        myLinkedList.appendNode(9);
        System.out.println(myLinkedList);
        myLinkedList.deleteNode(9);
        System.out.println(myLinkedList);
        boolean exist = myLinkedList.contain(90);
        boolean empty = myLinkedList.empty();
        System.out.println("exist: " + exist + ", empty: " + empty);
    }
}
