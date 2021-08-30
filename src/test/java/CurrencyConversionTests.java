import Selectors.ConversionPageSelectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CurrencyConversionTests extends TestBase {

    @Test
    public void OnFillingBuyInputSellInputIsEmptied() throws InterruptedException {
        currencyConversionPage.NavigateTo();
        currencyConversionPage.FillInput(ConversionPageSelectors.SellInputSelector, "someText");
        currencyConversionPage.FillInput(ConversionPageSelectors.BuyInputSelector, "123");

        AssertInputIsEmpty(ConversionPageSelectors.SellInputSelector);
    }

    @Test
    public void OnFillingSellInputBuyInputIsEmptied() throws InterruptedException {
        currencyConversionPage.NavigateTo();
        currencyConversionPage.FillInput(ConversionPageSelectors.BuyInputSelector, "someText");
        currencyConversionPage.FillInput(ConversionPageSelectors.SellInputSelector, "123");

        AssertInputIsEmpty(ConversionPageSelectors.BuyInputSelector);
    }

    @Test
    public void ChangingCountryUpdatesCurrency() throws InterruptedException {
        currencyConversionPage.NavigateTo();
        currencyConversionPage.SelectCountry("BG");

        AssertElementContainsText(ConversionPageSelectors.currencyInput, "BGN");
    }

    @Test
    public void LossAmountTextBoxIsDisplayedWhenBankProviderExchangeAmountLowerThenPaysera() throws InterruptedException {
        currencyConversionPage.NavigateTo();
        WebElement payseraAmountElement = _wait.until(ExpectedConditions.visibilityOfElementLocated(ConversionPageSelectors.payseraAmountValue));
        WebElement swedbankAmountElement = _wait.until(ExpectedConditions.visibilityOfElementLocated(ConversionPageSelectors.swedbankAmountValue));
        BigDecimal payseraAmountValue = new BigDecimal(payseraAmountElement.getText());
        BigDecimal swedbankAmountValue = new BigDecimal(swedbankAmountElement.getText());
        if (payseraAmountValue.compareTo(swedbankAmountValue) == 1 ) {
            WebElement otherBankLossElement = _driver.findElement(ConversionPageSelectors.otherBankLossValue);
            Assert.assertTrue(otherBankLossElement.isDisplayed());
            String otherBankLossValueString = otherBankLossElement.getText().replace('(', ' ').replace(')', ' ').trim();
            BigDecimal otherBankLossValue = new BigDecimal(otherBankLossValueString);
            BigDecimal expectedLossValue = swedbankAmountValue.subtract(payseraAmountValue);
            Assert.assertEquals(expectedLossValue, otherBankLossValue);
        }
    }
}
