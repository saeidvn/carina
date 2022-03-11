package com.solvd.carina.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.page.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchBlock extends AbstractUIObject {

    @FindBy(xpath = "//a[contains(@class,'search-suggestion') and contains(@href, '/search?q=cap')]")
    private ExtendedWebElement capButton;

    public SearchBlock(WebDriver driver) {
        super(driver);
    }

    public ResultPage clickOnCap() {
        capButton.clickIfPresent();
        return new ResultPage(driver);
    }

    public ResultPage getProductResult() {
        return new ResultPage(driver);
    }

    public boolean newFrameIsVisible() {
        return this.capButton.isPresent();
    }
}