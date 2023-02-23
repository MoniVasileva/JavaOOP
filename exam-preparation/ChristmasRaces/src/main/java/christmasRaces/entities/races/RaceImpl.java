package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {

    private static String name;
    private static int laps;
    private static Collection<Driver> drivers;


    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        drivers = new ArrayList<>();
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_LAPS);
        }
        this.laps = laps;
    }

    private void setName(String name) {
        if (name == null || name.length() < 5 || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }else if (!driver.getCanParticipate()){
            throw  new IllegalArgumentException(DRIVER_NOT_PARTICIPATE);
        }else if (drivers.contains(driver)){
            throw new IllegalArgumentException(DRIVER_ALREADY_ADDED);
        }
        drivers.add(driver);
    }
}
