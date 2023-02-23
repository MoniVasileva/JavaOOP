package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{

    private String model;
    private int horsePower;
    private double cubicCentimeters;
    private int minimumHP;
    private int maximumHP;

    public BaseCar(String model,double cubicCentimeters,int horsePower) {
        setModel(model);
        setHorsePower(horsePower);
        this.cubicCentimeters=cubicCentimeters;

    }

    private void setHorsePower(int horsePower) {

        this.horsePower=horsePower;
    }

    private void setModel(String model) {
        if (model==null || model.trim().isEmpty()){
            throw  new IllegalArgumentException(INVALID_MODEL);
        }
        this.model=model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return (cubicCentimeters/horsePower)*laps;
    }
}
