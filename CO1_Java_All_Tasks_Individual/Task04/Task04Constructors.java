class ParkingTicket {
    private final int ticketNumber;
    private final String registrationNumber;

    ParkingTicket() {
        this(0, "UNKNOWN");
    }

    ParkingTicket(int ticketNumber, String registrationNumber) {
        this.ticketNumber = ticketNumber;
        this.registrationNumber = registrationNumber;
    }

    ParkingTicket(ParkingTicket other) {
        this(other.ticketNumber, other.registrationNumber);
    }

    public String toString() {
        return "Ticket " + ticketNumber + " for " + registrationNumber;
    }
}

public class Task04Constructors {
    public static void main(String[] args) {
        ParkingTicket first = new ParkingTicket(1001, "TN01AB1234");
        ParkingTicket copy = new ParkingTicket(first);
        ParkingTicket defaultTicket = new ParkingTicket();
        System.out.println(first);
        System.out.println(copy);
        System.out.println(defaultTicket);
    }
}
