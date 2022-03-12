package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.page.components.FilterBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

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
        setPageAbsoluteURL(R.CONFIG.get("AccessoriesPage_url"));
    }

    public FilterBlock clickFilterButton() {
        filterButton.clickIfPresent();
        return new FilterBlock(driver);
    }

    public boolean isFilterButtonVisible() {
        return filterButton.isPresent();
    }

    public List<String> getProductPricesAsStrings() {
        return productPrices.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getProductPricesAsNumbers() {
        return getProductPricesAsStrings().stream()
                .map(price -> price.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public ProductListResultPage clickOnWishListButton() {
        wishListButton.clickIfPresent();
        return new ProductListResultPage(driver);
    }

    /**
     * How to add more than one index???
     */
    public void addProductToWishlist() {
        addToWishlistButton.format(1).click();
        addToWishlistButton.format(2).click();
        addToWishlistButton.format(3).click();
    }

    public boolean isWishlistListEmpty() {
        return productPrices.isEmpty();
    }

    public void clickOnClosePopUp() {
        popupButton.clickIfPresent(5);
    }

    public boolean isPopupVisible() {
        return popupButton.isVisible();
    }
}
