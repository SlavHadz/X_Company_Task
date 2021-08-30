package Selectors;

import org.openqa.selenium.By;

public final class ConversionPageSelectors {

    private ConversionPageSelectors() {

    };

    public static By BuyInputSelector = By.cssSelector("input[data-ng-model='currencyExchangeVM.filter.to_amount']");
    public static By SellInputSelector = By.cssSelector("input[data-ng-model='currencyExchangeVM.filter.from_amount']");
    public static By countryButton = By.cssSelector("span.js-localization-popover");
    public static By countriesDropdown = By.cssSelector("button#countries-dropdown");
    public static By currencyInput = By.cssSelector("div[data-on-select=\"currencyExchangeVM.onCurrencyChange('from')\"] span[data-ng-bind]");
    public static By payseraAmountValue = By.cssSelector("td[data-title=\"Paysera rate\"] span.commercial-rate span");
    public static By swedbankAmountValue = By.cssSelector("td[data-title=\"Swedbank amount\"] span[data-ng-class] span.ng-binding:first-child");
    public static By otherBankLossValue = By.cssSelector("td[data-title=\"Swedbank amount\"] span[data-ng-class] span[class*=\"other-bank-loss\"]");

    public static By countryOption(String countryCode) {
        return By.cssSelector("ul[aria-labelledby='countries-dropdown'] a[href*='" + countryCode + "']");
    };
}
