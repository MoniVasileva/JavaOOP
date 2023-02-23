package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {

    private static final int MINIMUM_HP = 400;
    private static final int MAXIMUM_HP = 600;
    private static final double CUBIC_CENTIMETERS = 5000.0;


    public MuscleCar(String model,  int horsePower) {
        super(model,CUBIC_CENTIMETERS, horsePower);
    }

    void setHorsePower(int horsePower) {
        if (horsePower< MINIMUM_HP ||horsePower>MAXIMUM_HP){
            throw new IllegalArgumentException(INVALID_HORSE_POWER);
        }
    }

}
