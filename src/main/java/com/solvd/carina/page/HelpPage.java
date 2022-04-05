package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends AbstractPage {

    @FindBy(xpath = "//h2[@class='gl-heading title___2eQQb withhtml___3ITcI gl-heading--m']")
    private ExtendedWebElement helpContentTitle;

    @FindBy(xpath = "//a[@class='logo-black___30Qp_ big___2Azet']")
    private ExtendedWebElement adidasHomePageButton;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHelpContentTitleVisible() {
        return helpContentTitle.isVisible();
    }

    public AdidasHomePage clickOnAdidasHomePageButton() {
        adidasHomePageButton.click();
        return new AdidasHomePage(driver);
    }

    public boolean isAdidasHomePageButtonPresent() {
        return adidasHomePageButton.isPresent();
    }
}
