import java.util.LinkedList;
import java.util.List;

import app.Polynomial;

public class Test {

    private static List<Integer> myList = new LinkedList<>();
    public static void main(String[] args) {
        // singleListTest();
        // doubleListTest();
        polynomialTest();
    }

    private static void polynomialTest() {
        Polynomial p1 = new Polynomial();
        p1.insertItem(3, 10);
        p1.insertItem(2, 7);
        p1.insertItem(4, 12);
        p1.insertItem(4, 0);
        System.out.println(p1);

        Polynomial p2 = new Polynomial();
        p2.insertItem(3, 10);
        p2.insertItem(2, 7);
        p2.insertItem(4, 12);
        p2.insertItem(8, 30);
        p2.insertItem(70, 0);
        p2.insertItem(12, 12);
        p2.insertItem(3, 17);
        System.out.println(p2);
        
        Polynomial p3 = Polynomial.addPolynomials(p1, p2);
        System.out.println(p3);

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
