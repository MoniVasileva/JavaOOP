package restaurant;

import restaurant.core.ControllerImpl;
import restaurant.core.EngineImpl;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import restaurant.io.ConsoleReader;
import restaurant.io.ConsoleWriter;
import restaurant.repositories.BeverageRepositoryImpl;
import restaurant.repositories.HealthyFoodImpl;
import restaurant.repositories.TableRepositoryImpl;
import restaurant.repositories.interfaces.*;

public class Main {


    public static void main(String[] args) {


      HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthyFoodImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository= new TableRepositoryImpl();


        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
