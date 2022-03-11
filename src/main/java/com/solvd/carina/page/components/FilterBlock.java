package com.solvd.carina.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.page.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterBlock extends AbstractUIObject {

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (low - high)']")
    private ExtendedWebElement lowPriceToHighButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (high - low)']")
    private ExtendedWebElement highPriceToLowButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Top Sellers']")
    private ExtendedWebElement topSellersButton;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--primary gl-cta--full-width']")
    private ExtendedWebElement applyButton;

    public FilterBlock(WebDriver driver) {
        super(driver);
    }

    public void clickLowPriceToHigh() {
        lowPriceToHighButton.clickIfPresent();
    }

    public void clickHighPriceToLow() {
        highPriceToLowButton.clickIfPresent();
    }

    public void clickTopSellersButton() {
        topSellersButton.clickIfPresent();
    }

    public ResultPage clickApplyButton() {
        applyButton.clickIfPresent();
        return new ResultPage(driver);
    }

    public ExtendedWebElement getApplyButton() {
        return applyButton;
    }

    public boolean isLowPriceToHighButtonIsVisible() {
        return isAnyElementPresent(lowPriceToHighButton);
    }

    public boolean isHighPriceToLowButtonIsVisible() {
        return this.highPriceToLowButton.isVisible();
    }

    public boolean isTopSellersButtonIsVisible() {
        return this.topSellersButton.isVisible();
    }

}
