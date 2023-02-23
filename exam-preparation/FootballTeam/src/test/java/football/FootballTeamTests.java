package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private Footballer footballer;

    @Before
    public void setUp() {
        this.footballTeam = new FootballTeam("Moni", 2);
        this.footballer = new Footballer("Moni");
    }

    @Test
    public void test_ShouldCreate() {
        assertEquals("Moni", footballTeam.getName());
        assertEquals(2, footballTeam.getVacantPositions());
        assertEquals(0, footballTeam.getCount());

    }

    @Test
    public void getName_ShouldReturnName() {
        footballTeam.addFootballer(footballer);
        assertEquals("Moni", footballTeam.getName());
    }

    @Test
    public void setName() {
        assertEquals("Moni", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void setName_shouldThrowException() {
        FootballTeam footballTeam1 = new FootballTeam(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void setName_shouldThrowException_becauseEmpty() {
        FootballTeam footballTeam1 = new FootballTeam("", 1);
    }

    @Test
    public void getVacantPositions_test() {
        assertEquals(2, footballTeam.getVacantPositions());
    }

    @Test
    public void test_setVacantPositions() {
        FootballTeam footballTeam1 = new FootballTeam("a", 1);
        assertEquals(1, footballTeam1.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_setVacantPositions_shouldThrow() {
        FootballTeam footballTeam1 = new FootballTeam("a", -1);
    }

    @Test
    public void test_getCount() {
        assertEquals(0, footballTeam.getCount());
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addFootballers_IsFull() {
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void removeFootballer_test() {
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
        footballTeam.removeFootballer(footballer.getName());
        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFootballer_ShouldThrow() {
        footballTeam.removeFootballer(footballer.getName());
    }

    @Test
    public void test_FootBallerForSale() {
        footballTeam.addFootballer(footballer);
        assertEquals(footballer, footballTeam.footballerForSale(footballer.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FootBallerForSale_ShouldThrow() {
        footballTeam.footballerForSale(footballer.getName());
    }

    @Test
    public void getStatistics() {
        footballTeam.addFootballer(footballer);
        assertEquals("The footballer Moni is in the team Moni.", footballTeam.getStatistics());
    }

    @Test
    public void isActive_test() {
        assertTrue(footballer.isActive());
    }
@Test
    public void isActive_false(){
        footballer.setActive(false);
        assertFalse(footballer.isActive());
}
@Test
    public void test_footballerForSale_setsActive_false(){
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale(footballer.getName());
        assertFalse(footballer.isActive());
}

}
