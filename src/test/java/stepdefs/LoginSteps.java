package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class    LoginSteps {
    public static WebDriver driver;
//    WebDriver driver;

    @Given("the user navigates to the BKB homepage")
    public void the_user_navigates_to_the_BKB_homepage() {
        System.out.println("Setting up ChromeDriver...");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bkb.ch/");
    }

    @And("the user closes any pop-ups")
    public void the_user_closes_any_pop_ups() {
        try {
            // Example: Close cookie consent pop-up if it exists
            WebElement popup = driver.findElement(By.id("cookie-consent-accept"));
            if (popup.isDisplayed()) {
                popup.click();
            }
        } catch (Exception e) {
            // If the pop-up doesn't exist, continue
        }
    }

    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button-id")); // Replace with actual ID
        loginButton.click();
    }

    @And("the user enters {string} as Identification number")
    public void the_user_enters_id_number(String idNumber) {
        WebElement identInput = driver.findElement(By.id("ident-input-id")); // Replace with actual ID
        identInput.sendKeys(idNumber);
    }

    @And("the user enters {string} as Password")
    public void the_user_enters_password(String password) {
        WebElement passInput = driver.findElement(By.id("password-input-id")); // Replace with actual ID
        passInput.sendKeys(password);
    }

    @And("the user presses the Login button")
    public void the_user_presses_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("submit-button-id")); // Replace with actual ID
        loginButton.click();
    }

    @Then("a red error pop-up with {string} is displayed")
    public void a_red_error_pop_up_with_is_displayed(String expectedMessage) {
        WebElement errorPopup = driver.findElement(By.className("error-popup-class")); // Replace with actual class
        String actualMessage = errorPopup.getText();
        Assert.assertTrue("Error message mismatch", actualMessage.contains(expectedMessage));

        // Close the browser after the test
        driver.quit();
    }
}
