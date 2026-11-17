interface Chargeable {
    double chargingFee(int kWh);

    default String chargingMessage() {
        return "Charging service is available.";
    }

    static boolean validEnergy(int kWh) {
        return kWh >= 0;
    }
}

abstract class Vehicle {
    private final String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public abstract double calculateFee(int minutes);
}

class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String registrationNumber) { super(registrationNumber); }

    @Override
    public double calculateFee(int minutes) {
        int hours = minutes <= 0 ? 0 : (minutes + 59) / 60;
        return hours * 30.0;
    }

    @Override
    public double chargingFee(int kWh) {
        if (!Chargeable.validEnergy(kWh)) {
            throw new IllegalArgumentException("kWh cannot be negative");
        }
        return kWh * 12.0;
    }
}

public class Task09Abstraction {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar("TN03EV1234");
        System.out.println("Parking fee: Rs " + car.calculateFee(70));
        System.out.println("Charging fee: Rs " + car.chargingFee(5));
        System.out.println(car.chargingMessage());
    }
}
