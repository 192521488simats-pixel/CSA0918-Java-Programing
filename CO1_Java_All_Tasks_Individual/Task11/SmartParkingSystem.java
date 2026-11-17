import java.util.*;

abstract class Vehicle {
    private final String registrationNumber;
    Vehicle(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank())
            throw new IllegalArgumentException("Registration number required");
        this.registrationNumber = registrationNumber;
    }
    public String getRegistrationNumber() { return registrationNumber; }
    public abstract double ratePerHour();
}

class Bike extends Vehicle {
    Bike(String number) { super(number); }
    public double ratePerHour() { return 10; }
}
class Car extends Vehicle {
    Car(String number) { super(number); }
    public double ratePerHour() { return 30; }
}
class ElectricCar extends Vehicle {
    ElectricCar(String number) { super(number); }
    public double ratePerHour() { return 30; }
}

class ActiveTicket {
    final Vehicle vehicle;
    final int floor;
    final int slot;
    final long entryMillis;
    ActiveTicket(Vehicle vehicle, int floor, int slot, long entryMillis) {
        this.vehicle = vehicle;
        this.floor = floor;
        this.slot = slot;
        this.entryMillis = entryMillis;
    }
}

public class SmartParkingSystem {
    private final String[][] slots;
    private final Map<String, ActiveTicket> active = new HashMap<>();

    public SmartParkingSystem(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];
        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }
    }

    public String enter(Vehicle vehicle) {
        String reg = vehicle.getRegistrationNumber();
        if (active.containsKey(reg)) return "ERROR: duplicate registration";
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = reg;
                    active.put(reg, new ActiveTicket(vehicle, f, s, System.currentTimeMillis()));
                    return "Ticket issued for " + reg + " at floor " + f + ", slot " + s;
                }
            }
        }
        return "ERROR: parking full";
    }

    public String exit(String registrationNumber, int minutesParked) {
        ActiveTicket ticket = active.remove(registrationNumber);
        if (ticket == null) return "ERROR: no active ticket";
        slots[ticket.floor][ticket.slot] = null;
        int hours = Math.max(0, (minutesParked + 59) / 60);
        double fee = hours * ticket.vehicle.ratePerHour();
        return registrationNumber + " exited; fee = Rs " + fee;
    }

    public static void main(String[] args) {
        SmartParkingSystem system = new SmartParkingSystem(new int[]{2, 1});
        System.out.println(system.enter(new Bike("TN01AA1111")));
        System.out.println(system.enter(new Car("TN02BB2222")));
        System.out.println(system.enter(new ElectricCar("TN03CC3333")));
        System.out.println(system.enter(new Car("TN04DD4444")));
        System.out.println(system.exit("TN02BB2222", 125));
        System.out.println(system.exit("TN02BB2222", 60));
    }
}
