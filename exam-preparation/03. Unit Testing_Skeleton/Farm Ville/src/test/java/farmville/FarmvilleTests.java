package farmville;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmvilleTests {
    private Animal chicken;
    private Animal lion;
    private Farm testFarm;


    @Before
    public void setUp() {
        testFarm = new Farm("SoftUni", 15);
        lion = new Animal("lion", 10);
        chicken = new Animal("Chicken", 1);
    }


    @Test
    public void test_ShouldCreateFarm() {
        Farm farm = new Farm("SoftUni", 15);
        assertEquals("SoftUni", farm.getName());
        assertEquals(15, farm.getCapacity());
        assertEquals(0, farm.getCount());

    }


    @Test(expected = NullPointerException.class)
    public void test_CreateShouldThrowException_BecauseNameIsWith_WhiteSpace() {
        new Farm(" ", 15);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateShouldThrowException_BecauseName_IsEmpty() {
        new Farm("", 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateShouldThrowException_BecauseCapacityIsNegative() {
        new Farm("SoftUni", -1);
    }

    @Test
    public void test_AddShould_AddSuccess() {

        testFarm.add(lion);
        assertEquals(1, testFarm.getCount());

        testFarm.add(chicken);
        assertEquals(2, testFarm.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddShould_ThrowException() {
        Farm farm = new Farm("SoftUni", 1);
        farm.add(lion);
        farm.add(chicken);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddShould_NotAdd_BecauseOf_NoCapacity() {
        testFarm.add(lion);
        testFarm.add(lion);
    }
    @Test
    public void test_ShouldRemove(){
        testFarm.add(lion);
        assertTrue(testFarm.remove(lion.getType()));
        assertEquals(0,testFarm.getCount());
    }
    @Test
    public void test_ShouldNotRemove(){
        testFarm.add(lion);
        assertFalse(testFarm.remove(chicken.getType()));
        assertEquals(1,testFarm.getCount());
    }

}
