package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> entities;

    public BeverageRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return entities.stream().filter(s -> s.getName().equals(drinkName) && s.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

    @Override
    public Collection getAllEntities() {
        return Collections.unmodifiableCollection(entities);
    }

    @Override
    public void add(Beverages entity) {
        entities.add(entity);
    }

}
