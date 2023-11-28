public class Customer implements Comparable<Customer> {
    private String name;
    private int arriveTime;
    private int timeToFix;

    public String getName() {
        return name;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public int getTimeToFix() {
        return timeToFix;
    }

    public Customer(String name, int arriveTime, int timeToFix) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.timeToFix = timeToFix;
    }

    @Override
    public int compareTo(Customer other) {
        int timeFixComparison = Integer.compare(this.timeToFix, other.timeToFix);
        if (timeFixComparison != 0) {
            return timeFixComparison;
        }
        return Integer.compare(this.arriveTime, other.arriveTime);
    }
}
