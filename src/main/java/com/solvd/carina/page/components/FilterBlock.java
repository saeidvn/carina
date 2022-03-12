package com.solvd.carina.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.page.ProductListResultPage;
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

    public void clickOnLowPriceToHighButton() {
        lowPriceToHighButton.clickIfPresent();
    }

    public void clickOnHighPriceToLowButton() {
        highPriceToLowButton.clickIfPresent();
    }

    public void clickOnTopSellersButton() {
        topSellersButton.clickIfPresent();
    }

    public ProductListResultPage clickOnApplyButton() {
        applyButton.clickIfPresent();
        return new ProductListResultPage(driver);
    }

    public boolean isLowPriceToHighPriceButtonPresent() {
        return lowPriceToHighButton.isPresent();
        /** Need to ask which one is better!!!
        return isAnyElementPresent(lowPriceToHighButton);
         */
    }

    public boolean isHighPriceToLowPriceButtonPresent() {
        return highPriceToLowButton.isPresent();
    }

    public boolean isTopSellersButtonPresent() {
        return topSellersButton.isPresent();
    }

    public boolean isApplyButtonPresent() {
        return applyButton.isPresent();
    }

}
