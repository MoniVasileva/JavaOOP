package Inheritance.NeedForSpeed;

public class Car extends Vehicle{
    final static double DEFAULT_FUEL_CONSUMPTION =3;
    public Car(int fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
