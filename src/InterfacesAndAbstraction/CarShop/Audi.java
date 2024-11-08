package InterfacesAndAbstraction.CarShop;

public class Audi extends CarImpl implements Rentable{
    private  Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }


    @Override
    public Integer getMinRentPerDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("%s\nMinimum rental period %d days. Price per day %f",super.toString(),minRentDay,pricePerDay);
    }
}
