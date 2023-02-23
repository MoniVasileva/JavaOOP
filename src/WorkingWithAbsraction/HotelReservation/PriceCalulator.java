package workingWithAbsraction.HotelReservation;

public class PriceCalulator {
    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalulator(double pricePerDay, int days, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice(){
        return pricePerDay*days*season.getMultiplier()*discount.getPriceReductionFactor();
    }
}
