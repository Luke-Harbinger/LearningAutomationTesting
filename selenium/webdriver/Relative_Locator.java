package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Relative_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }

    @Test
    public void TC_01() {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");

        By loginButtonBy = By.cssSelector("button.login-button"); // Define Login button
        By remembermeCheckboxBy = By.id("RememberMe"); // Define Rememberme checkbox
        WebElement forgotPasswordElement = driver.findElement(By.className("forgot-password")); // Define forgotPassword Textlink
        WebElement passwordTextboxElement = driver.findElement(By.id("Password")); // Define passwordTextbox
        //Define Element Rememberme Text by RelativeLocator | Can check GUI (location / position)
        WebElement remembermeTextElement = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .toRightOf(remembermeCheckboxBy)
                .toLeftOf(forgotPasswordElement)
                .below(passwordTextboxElement)
                .near(forgotPasswordElement)
        );
        System.out.println(remembermeTextElement.getText());

        List<WebElement> alllinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
        System.out.println(alllinks.size());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
