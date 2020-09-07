import org.testng.annotations.DataProvider;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int difference(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    @DataProvider(name = "dataForCheckFunctional")
    public Object[][] numbersData() {
        return new Object[][]{
                {sum(0, 1), 1},
                {sum(1, 1), 2},
                {sum(2, 1), 3},
                {sum(3, 1), 4},
                {sum(4, 1), 5},
                {sum(5, 1), 6},
                {sum(6, 1), 7},
                {sum(7, 1), 8}
        };
    }

}

