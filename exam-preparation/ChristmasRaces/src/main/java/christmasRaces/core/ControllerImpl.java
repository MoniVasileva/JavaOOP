package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Car> carRepository;
    private Repository<Driver> driverRepository;
    private Repository<Race> raceRepository;


    public ControllerImpl() {
        this.carRepository = new CarRepository();
        this.driverRepository = new DriverRepository();
        this.raceRepository = new RaceRepository();
    }

    @Override
    public String createDriver(String driver) {
        Driver driver1 = new DriverImpl(driver);
        if (driverRepository.getAll().contains(driver)) {
            throw new IllegalArgumentException(DRIVER_EXISTS);
        } else {
            this.driverRepository.add(driver1);
        }
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car=null;
        switch (type) {
            case "MuscleCar":
                car = new MuscleCar(model, horsePower);
                break;
            case "SportsCar":
                car = new SportsCar(model, horsePower);
                break;
        }
        if (carRepository.getAll().contains(car)) {
            throw new IllegalArgumentException(CAR_EXISTS);
        } else {
            this.carRepository.add(car);
        }

        return String.format(CAR_CREATED, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Car car = carRepository.getByName(driverName);
        Driver driver = driverRepository.getByName(driverName);

        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_NOT_FOUND);
        } else if (car == null) {
            throw new IllegalArgumentException(CAR_NOT_FOUND);
        } else {
            addCarToDriver(driverName, carModel);
        }

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (!raceRepository.getAll().contains(raceName)) {
            throw new IllegalArgumentException(RACE_NOT_FOUND);
        } else if (!carRepository.getAll().contains(driverName)) {
            throw new IllegalArgumentException(DRIVER_NOT_FOUND);
        } else {
            addDriverToRace(raceName, driverName);
        }
        return String.format(DRIVER_ADDED);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race==null) {
            throw new IllegalArgumentException(RACE_NOT_FOUND);
        }
        if(race.getDrivers().stream().filter(Driver::getCanParticipate).count() < 3 ) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> sortedDriver = race.getDrivers().stream().
                sorted((s1, s2) -> Double.compare(s2.getCar().calculateRacePoints(race.getLaps()), s1.getCar().calculateRacePoints(race.getLaps()))).
                collect(Collectors.toList());

        return String.format(DRIVER_FIRST_POSITION, sortedDriver.get(0).getName(), raceName) + System.lineSeparator() +
                String.format(DRIVER_SECOND_POSITION, sortedDriver.get(1).getName(), raceName) + System.lineSeparator() +
                String.format(DRIVER_THIRD_POSITION, sortedDriver.get(2).getName(), raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        if (!raceRepository.getAll().contains(race)) {
            throw new IllegalArgumentException(RACE_EXISTS);
        } else {
            raceRepository.add(race);
        }
        return String.format(RACE_CREATED, name);
    }
}
