package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFoods;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        healthyFoods = new ArrayList<>();
        beverages = new ArrayList<>();
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReserved;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        isReserved = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFoods.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverage) {
        beverages.add(beverage);
    }

    @Override
    public double bill() {
        double healthyFoodBill = healthyFoods.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beveragesBill = beverages.stream().mapToDouble(s -> s.getPrice()*s.getCounter()).sum();
        return healthyFoodBill + beveragesBill + allPeople();
    }

    @Override
    public void clear() {
        healthyFoods.clear();
        beverages.clear();
        isReserved = false;
        this.numberOfPeople = 0;
        this.pricePerPerson = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table - %d\n", number));
        sb.append(String.format("Size - %d\n", size));
        sb.append(String.format("Type - %s\n", getClass().getSimpleName()));
        sb.append(String.format("All price - %f", pricePerPerson));
        return sb.toString();
    }
}
