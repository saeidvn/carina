package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.page.components.FilterBlock;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AccessoriesPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    @FindBy(css = ".filter-panel-cta-btn___2zRtl")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//a[@class='wishlist_button_link___IAz6O outlined-icon-color___2xwB3 ']")
    private ExtendedWebElement wishListButton;

    @FindBy(xpath = "(//div[@class='plp-product-card__wishlist-button___qAqKB toggle_wishlist_button___my-ER  '])[%s]")
    private ExtendedWebElement addToWishlistButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupButton;

    public AccessoriesPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getEnvArg("url") + "y_3-accessories");
    }

    public FilterBlock clickFilterButton() {
        filterButton.click();
        return new FilterBlock(driver);
    }

    public List<Integer> getResultPricesAsNumbers() {
        List<Integer> productPrice = new ArrayList<>();
        productPrices.stream()
                .map(extendedWebElement -> extendedWebElement.getText()
                        .replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .forEach(productPrice::add);
        return productPrice;
    }

    public boolean isFilterButtonPresent() {
        return filterButton.isPresent();
    }

    public ProductListResultPage clickOnWishListButton() {
        wishListButton.click();
        return new ProductListResultPage(driver);
    }

    public void addProductToWishList (int indexOfProduct) {
        addToWishlistButton.format(indexOfProduct).click();
    }

    public boolean isWishlistListEmpty() {
        return productPrices.isEmpty();
    }

    public void clickOnClosePopUp() {
        popupButton.click();
    }

    public boolean isPopupVisible() {
        return popupButton.isVisible();
    }

    public void scrollDownPage() throws InterruptedException {
        int from = 0;
        int to = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from + "," + to + ")");
            Thread.sleep(1000);
            from = from + 500;
            to = to + 500;
        }
    }
}
