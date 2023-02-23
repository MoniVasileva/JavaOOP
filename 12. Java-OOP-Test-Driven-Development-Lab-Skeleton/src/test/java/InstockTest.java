import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class InstockTest extends TestCase {

    private Instock instock;

    @Before
    public void setUp() {
        this.instock = new Instock();
    }

    @Test
    public void test_Count_Should_Be_Zero_WhenInstockEmpty() {
        assertEquals(0, instock.getCount());
    }

    @Test
    public void test_Count_ShouldBeFive_WhenHasFiveItems() {
        int productCount = 5;
        addProducts(productCount);
        assertEquals(productCount, instock.getCount());
    }

    @Test
    public void test_Contains_ShouldBeTrue_OrFalse_WhenNoSuchProductPresent_OrNot() {
        Product product = addProducts(5)[3];
        assertFalse(instock.contains(new Product("not_present", 1, 1)));
    }

    @Test
    public void test_findRerurns_theCorrectProduct(){
        Product expected = addProducts(10)[4];
        Product actual = instock.find(4);
        assertNotNull(actual);
        assertEquals(expected.getLabel(),actual.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Find_ShouldThrow_WithNegativeIndex(){
        instock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Find_ShouldThrow_With_GreaterIndex(){
        addProducts(2);
        instock.find(-1);
    }

    private Product[] addProducts(int count) {

        Product[] arr = new Product[count];

        for (int i = 1; i <= count; i++) {
            Product product = new Product("product" + i, 10.00 + i, i);
            instock.add(product);
            arr[i - 1] = product;
        }
        return arr;
    }


}