class Ticket {
    private static int nextNumber = 1000;
    private final int number;
    private final String vehicleNo;

    Ticket(String vehicleNo) {
        this.number = ++nextNumber;
        this.vehicleNo = vehicleNo;
    }

    public int getNumber() { return number; }

    @Override
    public String toString() {
        return "Ticket " + number + " for " + vehicleNo;
    }
}

public class Task05StaticLifecycle {
    public static void main(String[] args) {
        Ticket northGate = new Ticket("TN01AA1111");
        Ticket southGate = new Ticket("TN02BB2222");
        System.out.println(northGate);
        System.out.println(southGate);
        // Once no reachable reference points to a ticket, it may be garbage-collected.
        northGate = null;
        System.out.println("North-gate ticket reference cleared.");
    }
}
