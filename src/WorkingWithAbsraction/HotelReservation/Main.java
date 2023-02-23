package workingWithAbsraction.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.pars(input[2]);
        Discount discount = Discount.pars(input[3]);

        PriceCalulator calculator = new PriceCalulator(pricePerDay, days, season, discount);
        System.out.printf("%.2f\n",calculator.calculatePrice());
    }
}
