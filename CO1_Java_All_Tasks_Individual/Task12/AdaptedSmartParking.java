import java.time.LocalTime;
import java.util.*;

interface Pass {
    boolean isValid();
    double discountOrFreeAmount();
}

class OneDayPass implements Pass {
    private final LocalTime validUntil;
    OneDayPass(LocalTime validUntil) { this.validUntil = validUntil; }
    public boolean isValid() { return LocalTime.now().isBefore(validUntil); }
    public double discountOrFreeAmount() { return Double.POSITIVE_INFINITY; }
}

abstract class Vehicle {
    private final String registrationNumber;
    Vehicle(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public String getRegistrationNumber() { return registrationNumber; }
    public abstract double calculateFee(int minutes, LocalTime entryTime);
}

class Car extends Vehicle {
    Car(String registrationNumber) { super(registrationNumber); }
    public double calculateFee(int minutes, LocalTime entryTime) {
        int hours = minutes <= 0 ? 0 : (minutes + 59) / 60;
        return hours * 30.0;
    }
}

class EBike extends Vehicle {
    EBike(String registrationNumber) { super(registrationNumber); }
    public double calculateFee(int minutes, LocalTime entryTime) { return 15.0; }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String registrationNumber) { super(registrationNumber); }
    public double calculateFee(int minutes, LocalTime entryTime) {
        int hours = minutes <= 0 ? 0 : (minutes + 59) / 60;
        double rate = (entryTime != null
                && !entryTime.isBefore(LocalTime.of(9, 0))
                && entryTime.isBefore(LocalTime.of(17, 0))) ? 60.0 : 30.0;
        return hours * rate;
    }
}

class ParkingFacility {
    private final String[][] slots;
    ParkingFacility(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];
        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }
    }
    public int[] allocate(String regNo) {
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = regNo;
                    return new int[]{f, s};
                }
            }
        }
        return null;
    }
}

public class AdaptedSmartParking {
    public static void main(String[] args) {
        // Five floors with different slot counts (jagged array representation).
        ParkingFacility facility = new ParkingFacility(new int[]{20, 25, 30, 35, 40});
        System.out.println("Car fee (125 min): Rs "
                + new Car("TN01AA1111").calculateFee(125, LocalTime.of(10, 0)));
        System.out.println("E-bike flat fee: Rs "
                + new EBike("TN02BB2222").calculateFee(20, LocalTime.of(11, 0)));
        System.out.println("Delivery van (10 AM, 60 min): Rs "
                + new DeliveryVan("TN03CC3333").calculateFee(60, LocalTime.of(10, 0)));
        System.out.println("Allocated slot: "
                + Arrays.toString(facility.allocate("TN04DD4444")));
        Pass pass = new OneDayPass(LocalTime.now().plusHours(12));
        System.out.println("One-day pass valid: " + pass.isValid());
    }
}
