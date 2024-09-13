package stepdefs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

import static stepdefs.GivenUserOpensCalculator.driver; // Import driver from GivenUserOpensCalculator

public class ReadCredentials {

    @And("the user enters credentials from the JSON file")
    public void the_user_enters_credentials_from_json() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode credentials = objectMapper.readTree(new File("src/test/credentials.json"));

        for (JsonNode credential : credentials.get("credentials")) {
            String username = credential.get("username").asText();
            String password = credential.get("password").asText();

            WebElement identInput = driver.findElement(By.id("ident-input-id"));
            identInput.clear();
            identInput.sendKeys(username);

            WebElement passInput = driver.findElement(By.id("password-input-id"));
            passInput.clear();
            passInput.sendKeys(password);

            // Press login
            WebElement loginButton = driver.findElement(By.id("submit-button-id"));
            loginButton.click();

            // Assert red error pop-up (reuse your previous assertion method)
        }
    }
}
