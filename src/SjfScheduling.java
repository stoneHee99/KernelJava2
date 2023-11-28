import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SjfScheduling implements Scheduling{

    @Override
    public List<Customer> schedule(List<Customer> customers) {
        PriorityQueue<Customer> queue = new PriorityQueue<>();

        for (Customer customer : customers) {
            queue.add(customer);
        }

        List<Customer> sortedCustomers = new ArrayList<>();
        while (!queue.isEmpty()) {
            sortedCustomers.add(queue.poll());
        }

        return sortedCustomers;
    }
}
