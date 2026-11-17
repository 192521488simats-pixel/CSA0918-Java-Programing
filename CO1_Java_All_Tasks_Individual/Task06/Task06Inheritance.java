abstract class Vehicle {
    protected final String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        System.out.println("Vehicle constructor");
    }

    abstract double ratePerHour();
}

class Car extends Vehicle {
    Car(String registrationNumber) {
        super(registrationNumber);
        System.out.println("Car constructor");
    }

    @Override
    double ratePerHour() { return 30.0; }
}

class ElectricCar extends Car {
    ElectricCar(String registrationNumber) {
        super(registrationNumber);
        System.out.println("ElectricCar constructor");
    }
}

public class Task06Inheritance {
    public static void main(String[] args) {
        ElectricCar ev = new ElectricCar("TN03EV1234");
        System.out.println("Rate per hour: Rs " + ev.ratePerHour());
    }
}
