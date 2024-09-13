package stepdefs;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WhenUserPressesOperation {
    @When("the user presses on the {string} sign")
    public void pressOperation(String operation) {
        WebElement operationButton;
        switch (operation) {
            case "+":
                operationButton = GivenUserOpensCalculator.getDriver().findElement(By.name("Plus"));
                break;
            case "-":
                operationButton = GivenUserOpensCalculator.getDriver().findElement(By.name("Minus"));
                break;
            case "*":
                operationButton = GivenUserOpensCalculator.getDriver().findElement(By.name("Multiply by"));
                break;
            case "/":
                operationButton = GivenUserOpensCalculator.getDriver().findElement(By.name("Divide by"));
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
        operationButton.click();
    }
}
