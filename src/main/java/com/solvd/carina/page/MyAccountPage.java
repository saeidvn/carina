package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='gl-flex-display col-l-24']")
    private ExtendedWebElement myAccountStatus;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeUserStatusVisible() {
        return myAccountStatus.isVisible();
    }
}
