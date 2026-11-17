import java.util.Objects;

abstract class Vehicle {
    private final String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() { return registrationNumber; }
    abstract double ratePerHour();

    @Override
    public boolean equals(Object other) {
        return other instanceof Vehicle
                && registrationNumber.equals(((Vehicle) other).registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + registrationNumber + "]";
    }
}

class Car extends Vehicle {
    Car(String registrationNumber) { super(registrationNumber); }
    @Override double ratePerHour() { return 30.0; }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String registrationNumber) { super(registrationNumber); }
    @Override double ratePerHour() { return 10.0; }
}

public class Task07Overriding {
    public static void main(String[] args) {
        Vehicle car = new Car("TN01AB1234");
        Vehicle bike = new TwoWheeler("TN02CD5678");
        System.out.println(car + ", rate Rs " + car.ratePerHour());
        System.out.println(bike + ", rate Rs " + bike.ratePerHour());
        System.out.println("Same registration? "
                + car.equals(new Car("TN01AB1234")));
    }
}
