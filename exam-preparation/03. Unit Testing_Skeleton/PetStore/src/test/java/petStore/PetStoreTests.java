package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {

    private static final String SPECIE = "Dog";
    private static final int MAX_WEIGHT = 30;
    private static final double PRICE = 100.00;
    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animal = new Animal(SPECIE, MAX_WEIGHT, PRICE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_GetAnimals_ShouldReturn_UnmodifiableList() {
        List<Animal> animals = petStore.getAnimals();
        animals.remove(1);
    }

    @Test
    public void test_GetCount() {
        assertEquals(0, petStore.getCount());
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());

    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_ShouldReturnEmptyList() {
        petStore.addAnimal(animal);
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT + 10);
        assertTrue(animals.isEmpty());
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_ShouldReturn_OnlyTheHeavier() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("test", MAX_WEIGHT - 2, PRICE));
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT - 1);
        assertEquals(1, animals.size());
        assertEquals(animal.getSpecie(), animals.get(0).getSpecie());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addAnimal() {
        petStore.addAnimal(null);
    }

    @Test
    public void test_GetTheMostExpensiveAnimal_ShouldReturnNull_WhenEmpty() {
        Animal animal1 = petStore.getTheMostExpensiveAnimal();
        assertNull(animal1);
    }

    @Test
    public void test_GetTheMostExpensiveAnimal() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal(SPECIE, MAX_WEIGHT, PRICE - 10));
        Animal actual = petStore.getTheMostExpensiveAnimal();
        assertEquals(animal.getPrice(), actual.getPrice(), 0.0);
    }
    @Test
    public void test_findAllAnimalSpecie_ShouldReturnEmptyList_WhenNoAnimals(){
        List<Animal> bySpecie = petStore.findAllAnimalBySpecie(SPECIE);
        assertTrue(bySpecie.isEmpty());
    }
    @Test
    public void test_findAllAnimalSpecie(){
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Goat",MAX_WEIGHT,PRICE));
        List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
        assertEquals(1,animals.size());
        assertEquals(SPECIE,animals.get(0).getSpecie());
    }
}

