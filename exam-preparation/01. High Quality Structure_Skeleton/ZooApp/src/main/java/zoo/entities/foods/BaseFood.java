package zoo.entities.foods;

public abstract class BaseFood implements Food {

    private int calories;
    private double price;

    protected BaseFood(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }
}
