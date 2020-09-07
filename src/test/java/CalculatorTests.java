import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class CalculatorTests {
    Calculator calculator;

    @BeforeGroups(groups = {"unnecessary"})
    public void beforeGroups() {
        System.out.println("beforeGroups");
    }

    @BeforeSuite
    public void helloAll() {
        System.out.println("Hello TMS");
    }

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void doThat() {
        System.out.println("-------------------------------");
    }

    @Test(description = "Check functional by sum with negative numbers")
    public void sumWithNegativeNumbers() {
        assertEquals(calculator.sum(-1, -1), -2);
    }

    @Test(dependsOnGroups = {"unnecessary"})
    public void differenceWithNegativeNumbers() {
        assertEquals(calculator.difference(-1, -1), 0);
    }

    @Test(priority = 1)
    public void multiplyWithNegativeNumbers() {
        assertEquals(calculator.multiply(-1, -1), 1);
    }

    @Test(groups = {"necessary"})
    public void divideWithNegativeNumbers() {
        assertEquals(calculator.divide(-1, -1), 1);
    }

    @Test(priority = 2)
    public void sumWithPositiveNumbers() {
        assertEquals(calculator.sum(1, 1), 2);
    }

    @Test(groups = {"unnecessary"})
    public void differenceWithPositiveNumbers() {
        assertEquals(calculator.difference(1, 1), 0);
    }

    @Test(dependsOnMethods = {"sumWithPositiveNumbers"})
    public void multiplyWithPositiveNumbers() {
        assertEquals(calculator.multiply(1, 1), 1);
    }

    @Test(description = "Positive test with using positive numbers")
    public void divideWithPositiveNumbers() {
        assertEquals(calculator.divide(1, 1), 1);
    }

    @Test (dataProvider = "dataForCheckFunctional", dataProviderClass = Calculator.class)
    public void ForTryingDataProviderWithRandomNumbers(int actual, int expected) {
        assertEquals(actual, expected);
    }

    @Test(retryAnalyzer = Retry.class)
    public void sumWithUsingZero() {
        assertEquals(calculator.sum(0, 1), 1);
    }

    @Test(retryAnalyzer = Retry.class)
    public void differenceWithUsingZero() {
        assertEquals(calculator.difference(0, 1), -1);
    }

    @Test(invocationCount = 4, threadPoolSize = 2)
    public void multiplyWithUsingZero() {
        assertEquals(calculator.multiply(0, 1), 0);
    }

    @Test(enabled = false)
    public void divideWithUsingZero() {
        assertEquals(calculator.divide(0, 1), 1);
    }

    @Test(description = "Negative test", expectedExceptions = ArithmeticException.class)
    public void divideByZero() {
        assertEquals(calculator.divide(1, 0), 0);
    }

    @Parameters(value = {"someNumber"})
    @Test
    public void tryToUseParametersWithRandomNumbers(int expected) {
        assertEquals(calculator.difference(5, -10), expected);
    }

    @Parameters(value = {"someNumber"})
    @Test
    public void tryToUseOptionalWithRandomNumbers(@Optional("15") int expected) {
        assertEquals(calculator.difference(5, -10), expected);
    }

    @Test(description = "just test =)")
    public void justTestToExcludeByXml() {
        assertEquals(calculator.multiply(21, 1), 21);
    }
}
