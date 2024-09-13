package stepdefs;

import helpers.CalculatorHelper;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThenResultIsAsExpected {

    @Then("the result is {double}")
    public void checkResult(double expectedResult) {
        // Press equal sign
        WebElement equalButton = GivenUserOpensCalculator.getDriver().findElement(By.name("Equals"));
        equalButton.click();

        // Get the result from the calculator
        WebElement resultElement = GivenUserOpensCalculator.getDriver().findElement(By.xpath("//Text[@AutomationId='CalculatorResults']"));
        String resultText = resultElement.getText().replace("Display is", "").trim();

        // Parse result to double and round to two decimal places
        double actualResult = CalculatorHelper.roundToTwoDigits(Double.parseDouble(resultText));

        // Assert both results
        assertEquals(expectedResult, actualResult, "The calculator result is incorrect.");
    }
}
