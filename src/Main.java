import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = getTestCustomer();
        Scheduling sjfScheduling = new SjfScheduling();
        Scheduling fifoScheduling = new FifoScheduling();
        printScheduleDetails(customers, fifoScheduling);
        printScheduleDetails(customers, sjfScheduling);
    }

    private static List<Customer> getTestCustomer() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("이영주", 0, 1));
        customers.add(new Customer("이종찬", 2, 12));
        customers.add(new Customer("장호윤", 5, 5));
        customers.add(new Customer("문찬욱", 6, 6));
        customers.add(new Customer("김찬규", 7, 3));
        customers.add(new Customer("손민우", 9, 1));
        customers.add(new Customer("송예진", 10, 3));
        return customers;
    }

    private static void printScheduleDetails(List<Customer> customers, Scheduling scheduling) {
        List<Customer> scheduledCustomers = scheduling.schedule(customers);

        int currentTime = 0;
        int totalWaitTime = 0;

        System.out.println("고객 순서:");
        for (Customer customer : scheduledCustomers) {
            int waitTime = Math.max(0, currentTime - customer.getArriveTime());
            totalWaitTime += waitTime;
            if(currentTime < customer.getArriveTime()) currentTime = customer.getArriveTime();
            currentTime += customer.getTimeToFix();

            System.out.println("이름: " + customer.getName() + ", 도착 시간: " + customer.getArriveTime()
                    + ", 수리 시간: " + customer.getTimeToFix() + ", 대기 시간: " + waitTime);
        }

        System.out.println("총 수리 시간: " + currentTime);
        System.out.println("총 대기 시간: " + totalWaitTime);
    }

}
