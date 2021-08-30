package pages;

import Selectors.ConversionPageSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrencyConversionPage {

    private WebDriver _driver;
    private WebDriverWait _wait;
    private String pageUrl = "https://www.paysera.lt/v2/en-LT/fees/currency-conversion-calculator#/";

    public CurrencyConversionPage(WebDriver driver) {
        _driver = driver;
        _wait = new WebDriverWait(_driver, 10);
    }

    public void NavigateTo() throws InterruptedException {
        _driver.navigate().to(pageUrl);
    }

    public void FillInput(By selector, String text) {
        _wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).sendKeys(text);
    }

    public void SelectCountry(String countryCode) {
        _wait.until(ExpectedConditions.elementToBeClickable(ConversionPageSelectors.countryButton)).click();
        _wait.until(ExpectedConditions.elementToBeClickable(ConversionPageSelectors.countriesDropdown)).click();
        By countrySelector = ConversionPageSelectors.countryOption(countryCode);
        _wait.until(ExpectedConditions.elementToBeClickable(countrySelector)).click();
    }

    public void WaitForPageLoading() {

    }
}
