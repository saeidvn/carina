package com.solvd.carina.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.page.ProductListResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterBlock extends AbstractUIObject {

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (low - high)']")
    private ExtendedWebElement lowPriceToHighPriceButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (high - low)']")
    private ExtendedWebElement highPriceToLowPriceButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Top Sellers']")
    private ExtendedWebElement topSellersButton;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--primary gl-cta--full-width']")
    private ExtendedWebElement applyButton;

    public FilterBlock(WebDriver driver) {
        super(driver);
    }

    public void clickOnLowPriceToHighButton() {
        lowPriceToHighPriceButton.clickIfPresent();
    }

    public void clickOnHighPriceToLowButton() {
        highPriceToLowPriceButton.clickIfPresent();
    }

    public void clickOnTopSellersButton() {
        topSellersButton.clickIfPresent();
    }

    public ProductListResultPage clickOnApplyButton() {
        applyButton.clickIfPresent();
        return new ProductListResultPage(driver);
    }

    public boolean isLowPriceToHighPriceButtonPresent() {
        return lowPriceToHighPriceButton.isPresent();
    }

    public boolean isHighPriceToLowPriceButtonPresent() {
        return highPriceToLowPriceButton.isPresent();
    }

    public boolean isTopSellersButtonPresent() {
        return topSellersButton.isPresent();
    }

    public boolean isApplyButtonPresent() {
        return applyButton.isPresent();
    }

}
