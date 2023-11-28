import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FifoScheduling implements Scheduling{
    @Override
    public List<Customer> schedule(List<Customer> customers) {
        List<Customer> sortedCustomers = new ArrayList<>(customers);
        sortedCustomers.sort(Comparator.comparingInt(Customer::getArriveTime));
        return sortedCustomers;
    }
}
