
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    
    private static List<Integer> myList = new LinkedList<>();
    public static void main(String[] args) {
        // singleListTest();
        doubleListTest();
    }

    private static void doubleListTest() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.append("Monday");
        list.append("Tuesday");
        list.append("Wednesday");
        list.append("Thursday");
        System.out.println(list);
        list.add(0, "Sunday");
        System.out.println(list);
        list.remove("Wednesday");
        System.err.println(list);
    }

    private static void singleListTest() {
        
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.append("you");
        list.append("i");
        list.append("she");
        list.append("he");
        System.out.println(list);
        list.delete("you");
        list.delete(2);
        System.out.println(list);
        list.add("me", 1);
        System.out.println(list);
    }
}
