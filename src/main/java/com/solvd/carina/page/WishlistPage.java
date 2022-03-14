package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupButton;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnClosePopUp() {
        popupButton.click();
    }

    public boolean isPopupVisible() {
        return popupButton.isVisible();
    }

    public boolean isProductListEmpty() {
        return productPrices.isEmpty();
    }

}
