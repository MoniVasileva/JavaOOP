package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HealthyFoodImpl implements HealthFoodRepository<HealthyFood> {
    private Collection<HealthyFood> entities;

    public HealthyFoodImpl() {
        this.entities=new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return entities.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(entities);
    }

    @Override
    public void add(HealthyFood entity) {
        entities.add(entity);
    }
}
