import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public void setUpClass() {

    }

    @AfterClass
    public void tearDownClass() {

    }

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {

    }

    @Test(dataProvider = "addData")
    public void testAdd(int a, int b, int expected) {
        assertEquals(calculator.add(a, b), expected);
    }

    @DataProvider
    public Object[][] addData() {
        return new Object[][]{
                {1, 2, 3},
                {-1, 5, 4},
                {0, 0, 0}
        };
    }

    @Test
    public void testSubtract() {
        assertEquals(calculator.subtract(10, 5), 5, "Subtraction test failed");

    }

    @Test
    public void testMultiply() {
        assertEquals(calculator.multiply(3, 4), 12, "Multiplication test failed");
    }

    @Test(dependsOnMethods = "testMultiply")
    public void testDivide() {
        assertEquals(calculator.divide(10, 2), 5, "Division test failed");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
//    public void testDivideByZero() {
//        calculator.divide(5, 0);
//        }
    public void testDivideByZero() {
        new Calculator().divide(1, 10);
        Assert.fail("Should be exception");
    }
    }
