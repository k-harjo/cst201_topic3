package dq2;
import java.util.PriorityQueue;

public class DMV {

    public static void main(String[] args) {
        PriorityQueue<Customer> queue = new PriorityQueue<>();

        // Add customers to the queue
        queue.offer(new Customer("Alice", 2)); // Appointment
        queue.offer(new Customer("John", 3));  // Walk-in
        queue.offer(new Customer("Bob", 1));   // Special needs

        // Serve customers
        while (!queue.isEmpty()) {
            System.out.println("Now serving: " + queue.poll().name);
        }
    }
}

class Customer implements Comparable<Customer> {
    String name;
    int priority;

    public Customer(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.priority, other.priority);
    }
}
