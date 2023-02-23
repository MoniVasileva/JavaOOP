package cats;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {

    private Cat cat;
    private Cat lion;

    private House house;

    @Before
    public void setUp() {
        cat = new Cat("Moni");
        lion = new Cat(null);
        house = new House("House", 2);
    }

    @Test
    public void test_should_createHouse() {
        assertEquals("House", house.getName());
        assertEquals(2, house.getCapacity());
        assertEquals(0, house.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateShouldThrowException_BecauseNameIsWith_WhiteSpace() {
        new House(" ", 15);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateShouldThrowException_BecauseName_IsEmpty() {
        new House("", 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateShouldThrowException_BecauseCapacityIsNegative() {
        new House("SoftUni", -1);
    }

    @Test
    public void test_AddShould_AddSuccess() {

        house.addCat(lion);
        assertEquals(1, house.getCount());

        house.addCat(cat);
        assertEquals(2, house.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddShould_ThrowException() {
        House house1 = new House("Moni", 1);
        house1.addCat(lion);
        house1.addCat(cat);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddShould_NotAdd_BecauseOf_NoCapacity() {
        house.addCat(lion);
        house.addCat(lion);
        house.addCat(lion);
    }

    @Test
    public void test_ShouldRemove() {
        house.addCat(cat);
        assertEquals(1, house.getCount());
        house.removeCat(cat.getName());
        assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ShouldNotRemove() {
        house.addCat(cat);
        Cat cat1 = new Cat("Pesho");
        house.removeCat(cat1.getName());
        house.catForSale("Pesho");
    }

    @Test
    public void test_catForSale() {
        house.addCat(cat);
        house.catForSale("Moni");

        assertFalse(cat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_catForSale_ShouldThrowException() {
        house.addCat(cat);
        house.catForSale("Pesho");
    }

    @Test
    public void test_Statistics() {
        house.addCat(cat);
        assertEquals("The cat Moni is in the house House!", house.statistics());

    }


}
