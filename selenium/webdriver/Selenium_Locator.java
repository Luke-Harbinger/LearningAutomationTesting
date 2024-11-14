package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class Selenium_Locator {
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
        driver.get("https://demo.nopcommerce.com/register");

    }
//TestNG:Order Testcase by Alphabet
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("Luke");
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_Tagname() {
        driver.findElement(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText() {
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        driver.findElement(By.partialLinkText("Apply for"));
        driver.findElement(By.partialLinkText("for vendor"));
        driver.findElement(By.partialLinkText("vendor account"));
    }

    @Test
    public void TC_07_Css() {
        //ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));
        //Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));
        //Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));
        //Tagname
        driver.findElement(By.cssSelector("input"));
        //LinkText
        driver.findElement((By.cssSelector("a[href='/customer/addresses']")));
        //Partial LinkText
        driver.findElement((By.cssSelector("a[href*='addresses']")));
    }

    @Test
    public void TC_08_XPath() {
        //ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        //Class
        driver.findElement(By.xpath("//div[@class='page-title']"));
        //Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));
        //Tagname
        driver.findElement(By.xpath("//input"));
        //LinkText
        driver.findElement((By.xpath("//a[@href='/customer/addresses']")));
        driver.findElement((By.xpath("//a[text()='Addresses']")));
        //Partial LinkText
        driver.findElement((By.xpath("//a[contains(@href,'addresses')]")));
        driver.findElement((By.xpath("//a[contains(text(),'Addresses')]")));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
