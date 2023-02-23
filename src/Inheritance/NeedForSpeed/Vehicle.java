package Inheritance.NeedForSpeed;

public class Vehicle {
    final static double DEFAULT_FUEL_CONSUMPTION =1.25;
    public  double fuelConsumption;
    public double fuel;
    public int horsePower;

    public Vehicle(int fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        this.fuelConsumption=DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public void drive(double kilometers){
        double fuelNeeded = kilometers*fuelConsumption;
        if (fuel>=fuelNeeded){
            fuel=fuel-fuelNeeded;
        }

    }


}
