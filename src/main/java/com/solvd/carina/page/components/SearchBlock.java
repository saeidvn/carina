package com.solvd.carina.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.page.SearchResultPage;
import com.solvd.carina.page.ProductListResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchBlock extends AbstractUIObject {

    @FindBy(xpath = "//a[contains(@class,'search-suggestion') and contains(@href, '/search?q=cap')]")
    private ExtendedWebElement capButton;

    public SearchBlock(WebDriver driver) {
        super(driver);
    }

    public ProductListResultPage clickOnCapButton() {
        capButton.clickIfPresent(10);
        return new ProductListResultPage(driver);
    }

    public SearchResultPage noResultForSearch() {
        return new SearchResultPage(driver);
    }

    public boolean isNewFrameVisible() {
        return capButton.isPresent();
    }
}