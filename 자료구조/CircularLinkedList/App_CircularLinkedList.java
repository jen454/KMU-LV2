package CircularLinkedList;

import java.util.concurrent.atomic.AtomicInteger;

// 아래 코드에서 "구현" 이 필요한 부분을 구현하세요.
public class App_CircularLinkedList {
    public static void testCase11() {
        CircularLinkedList<Integer> list = new CircularLinkedList();
        ItemComparator<Integer> c = (lhs, rhs) -> {
            if (lhs == null) return 1;
            return lhs - rhs;
        };
        AtomicInteger visits = new AtomicInteger(0);
        Visitor<Integer> v = (node) -> {
            if(visits.get() == 0) {
                System.out.print("( " + node.getData());
            } else if(node.isTerminal()) {
                System.out.println(" )");
            } else {
                System.out.print(", " + node.getData());
            }
            visits.set(visits.get() + 1);
        };
        list.add(1,c);
        list.add(3,c);
        list.add(5,c);
        list.add(7,c);
        list.add(9,c);

        list.invert();
        list.traverse(v);
    }
    public static void testCase12() {
        CircularLinkedList<String> list = new CircularLinkedList();
        ItemComparator<String> c = (lhs, rhs) -> {
            if (lhs == null) return 1;
            return lhs.compareTo(rhs);
        };
        AtomicInteger visits = new AtomicInteger(0);
        Visitor<String> v = (node) -> {
            if (visits.get() == 0) {
                System.out.print("( \"" + node.getData());
            } else if (node.isTerminal()) {
                System.out.println("\" )");
            } else {
                System.out.print("\", \"" + node.getData());
            }
            visits.set(visits.get() + 1);
        };

        list.add("Ant",c);
        list.add("Bear",c);
        list.add("Cat",c);
        list.add("Dog",c);

        list.invert();
        list.traverse(v);
    }
    public static void testCase21() {
        CircularLinkedList<Integer> listA = new CircularLinkedList();
        CircularLinkedList<Integer> listB = new CircularLinkedList();
        ItemComparator<Integer> c = (lhs, rhs) -> {
            if (lhs == null) return 1;
            return lhs - rhs;
        };
        AtomicInteger visits = new AtomicInteger(0);
        Visitor<Integer> v = (node) -> {
            if (visits.get() == 0) {
                System.out.print("( " + node.getData());
            } else if (node.isTerminal()) {
                System.out.println(" )");
            } else {
                System.out.print(", " + node.getData());
            }
            visits.set(visits.get() + 1);
        };

        listA.add(1,c);
        listA.add(3,c);
        listA.add(5,c);
        listA.add(7,c);
        listA.add(9,c);
        listB.add(2,c);
        listB.add(10,c);
        listB.add(12,c);
        listB.add(20,c);

        listA.concatenate(listB);
        listA.traverse(v);
    }
    public static void testCase22() {
        CircularLinkedList<String> listA = new CircularLinkedList();
        CircularLinkedList<String> listB = new CircularLinkedList();
        ItemComparator<String> c = (lhs, rhs) -> {
            if (lhs == null) return 1;
            return lhs.compareTo(rhs);
        };
        AtomicInteger visits = new AtomicInteger(0);
        Visitor<String> v = (node) -> {
            if (visits.get() == 0) {
                System.out.print("( \"" + node.getData());
            } else if (node.isTerminal()) {
                System.out.println("\" )");
            } else {
                System.out.print("\", \"" + node.getData());
            }
            visits.set(visits.get() + 1);
        };

        listA.add("Ant",c);
        listA.add("Cat",c);
        listB.add("Bear",c);
        listB.add("Dog",c);

        listA.concatenate(listB);
        listA.traverse(v);
    }
    public static void main(String[] args) {
        testCase11();
        testCase12();
        testCase21();
        testCase22();
    }
}