package Inheritance.NeedForSpeed;

public class RaceMotorcycle extends Motorcycle{
    final static double DEFAULT_FUEL_CONSUMPTION =8;

    public RaceMotorcycle(int fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
