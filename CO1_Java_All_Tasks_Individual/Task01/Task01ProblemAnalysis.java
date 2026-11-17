import java.util.*;

class Vehicle {
    private final String registrationNumber;
    private final String type;
    private final long entryTime;

    Vehicle(String registrationNumber, String type, long entryTime) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.entryTime = entryTime;
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public String getType() { return type; }
    public long getEntryTime() { return entryTime; }
}

class ParkingTicket {
    private static int nextTicketNumber = 1000;
    private final int ticketNumber;
    private final Vehicle vehicle;

    ParkingTicket(Vehicle vehicle) {
        this.ticketNumber = ++nextTicketNumber;
        this.vehicle = vehicle;
    }

    public int getTicketNumber() { return ticketNumber; }
    public Vehicle getVehicle() { return vehicle; }
}

public class Task01ProblemAnalysis {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("TN01AB1234", "Car", System.currentTimeMillis());
        ParkingTicket ticket = new ParkingTicket(vehicle);
        System.out.println("Vehicle: " + vehicle.getRegistrationNumber());
        System.out.println("Type: " + vehicle.getType());
        System.out.println("Ticket: " + ticket.getTicketNumber());
    }
}
