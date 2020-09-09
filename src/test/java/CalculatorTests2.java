import org.testng.annotations.Test;

public class CalculatorTests2 {

    @Test(groups = {"try"})
    public void itIsTestForRunThroughXml() {
        System.out.println("try to run some group");
    }

    @Test
    public void itIsTestForRunThroughXml2() {
        System.out.println("try2 to run some group");
    }
}
