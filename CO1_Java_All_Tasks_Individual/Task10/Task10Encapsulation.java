package parking.app;

class ParkingSlot {
    private final int floor;
    private final int slotNumber;
    private String registrationNumber;

    public ParkingSlot(int floor, int slotNumber) {
        if (floor < 0 || slotNumber < 0) {
            throw new IllegalArgumentException("Floor and slot must be non-negative");
        }
        this.floor = floor;
        this.slotNumber = slotNumber;
    }

    public int getFloor() { return floor; }
    public int getSlotNumber() { return slotNumber; }
    public String getRegistrationNumber() { return registrationNumber; }

    public void park(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank()) {
            throw new IllegalArgumentException("Registration number is required");
        }
        if (this.registrationNumber != null) {
            throw new IllegalStateException("Slot is already occupied");
        }
        this.registrationNumber = registrationNumber;
    }

    public void release() {
        if (registrationNumber == null) {
            throw new IllegalStateException("Slot is already free");
        }
        registrationNumber = null;
    }
}

public class Task10Encapsulation {
    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot(0, 4);
        slot.park("TN01AB1234");
        System.out.println("Floor: " + slot.getFloor());
        System.out.println("Slot: " + slot.getSlotNumber());
        System.out.println("Vehicle: " + slot.getRegistrationNumber());
        slot.release();
        System.out.println("After release: " + slot.getRegistrationNumber());
    }
}
