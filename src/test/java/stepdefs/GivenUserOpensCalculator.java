package stepdefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GivenUserOpensCalculator {
    private static WebDriver driver;

    @Given("the user opens the system calculator")
    public void openCalculator() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723"), caps);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
