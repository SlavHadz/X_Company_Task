import jdk.jfr.Timespan;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.CurrencyConversionPage;

import java.util.HashMap;

public class TestBase {
    protected WebDriver _driver;
    protected WebDriverWait _wait;
    CurrencyConversionPage currencyConversionPage;

    @BeforeMethod
    public void SetUp() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        _driver = new ChromeDriver();
        _wait = new WebDriverWait(_driver, 10);
        currencyConversionPage = new CurrencyConversionPage(_driver);
        _driver.manage().window().maximize();
    }

    @AfterMethod
    public void TearDown() {
        _driver.close();
        _driver.quit();
    }

    protected void AssertInputIsEmpty(By selector) {
        WebElement input = _wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        String text = input.getAttribute("value");
        Assert.assertEquals(text, "");
    }

    protected void AssertElementContainsText(By selector, String expectedText) {
        WebElement element = _wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
    }
}
