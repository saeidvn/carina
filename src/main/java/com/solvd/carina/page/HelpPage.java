package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends AbstractPage {

    @FindBy(xpath = "//h2[@class='gl-heading title___2eQQb withhtml___3ITcI gl-heading--m']")
    private ExtendedWebElement helpContentTitle;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public boolean helpContentTitleIsVisible() {
        return this.helpContentTitle.isVisible();
    }

}
