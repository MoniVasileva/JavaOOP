package Encapsulation.Pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]pizzaData=scanner.nextLine().split(" ");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        String[] doughData = scanner.nextLine().split(" ");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);

        Pizza pizza = new Pizza(pizzaName,numberOfToppings);
        Dough dough = new Dough(flourType,bakingTechnique,doughWeight);
        pizza.setDough(dough);


    }
}
