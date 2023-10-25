package dq1;

import java.util.ArrayDeque;

public class Deque {

    public static void main(String[] args) {
        ArrayDeque<String> d = new ArrayDeque<>();

        // add elements to the deque
        d.addLast("latte");  // add to the back
        System.out.println("Adding elements... " + d);
        
        d.addLast("macchiato");
        System.out.println("Adding elements... " + d);

        d.addLast("affogato");
        System.out.println("Adding elements... " + d);

        d.addFirst("frappuccino");
        System.out.println("Adding elements... " + d);

        d.addFirst("irish");
        System.out.println("Adding elements... " + d);

        d.addFirst("cappuccino");  // add to the front

        System.out.println("\nDeque after adding all elements: " + d + "\n");

        // remove elements from the deque
        d.removeLast();  // remove from the back
        System.out.println("Deque after removing back element: " + d + "\n");

        d.removeFirst();  // remove from the front
        System.out.println("Deque after removing front element: " + d + "\n");
    }
}
