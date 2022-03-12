package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.page.components.SearchBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdidasHomePage extends AbstractPage {

    @FindBy(xpath = "//a[@manual_cm_sp='header-_-customerinfo-_-Help']")
    private ExtendedWebElement headerHelpButton;

    @FindBy(xpath = "//a[@manual_cm_sp='footer-_-help']")
    private ExtendedWebElement footerHelpButton;

    @FindBy(xpath = "//a[@manual_cm_sp='footer-_-support-_-help & customer service']")
    private ExtendedWebElement helpAndCustomerServiceButton;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--tertiary profile_button_link___WQCT9 outlined-icon-color___1fd_i undefined']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//input[@id='login-register-auto-flow-input']")
    private ExtendedWebElement emailBox;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--primary gl-cta--full-width gl-vspace']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//input[@id='login-password']")
    private ExtendedWebElement passwordBox;

    @FindBy(xpath = "//button[contains(@class,'gl-cta gl-cta--primary') and contains(@data-auto-id,'login-form-login')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@class='gl-link gl-label--bold  link___1kK4C '][1]")
    private ExtendedWebElement visitYourAccountButton;

    @FindBy(css = ".searchinput___zXLAR")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = "//span[@class='btn-clear-search-filler___2Qh5i']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='gl-wishlist-icon wishlist_button___3ppwb outlined-icon-color___2xwB3']")
    private ExtendedWebElement wishListButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupButton;

    public AdidasHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public HelpPage clickOnHeaderHelpButton() {
        this.headerHelpButton.click();
        return new HelpPage(driver);
    }

    public boolean isHeaderHelpButtonPresent() {
        return this.headerHelpButton.isPresent();
    }

    /** They are used with 2nd help test(invisible help button on web)
    public HelpPage footerHelpButton() {
        this.footerHelpButton.click();
        return new HelpPage(driver);
    }

    public boolean isFooterHelpButtonPresent() {
        return this.footerHelpButton.isPresent();
    }
    */

    public HelpPage clickOnHelpAndCustomerServiceButton() {
        helpAndCustomerServiceButton.click();
        return new HelpPage(driver);
    }

    public boolean isHelpAndCustomerServicePresent() {
        return helpAndCustomerServiceButton.isPresent();
    }

    public void clickOnProfileButton() {
        profileButton.clickIfPresent();
    }

    public void TypeEmailInBox(String email) {
        emailBox.type(email);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void typePasswordInBox(String password) {
        passwordBox.type(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public MyAccountPage clickOnVisitYourAccountButton() {
        visitYourAccountButton.click();
        return new MyAccountPage(driver);
    }

    public SearchBlock typeInSearchBox(String productName) {
        searchBox.click();
        searchBox.hover();
        pause(5);
        searchBox.type(productName);
        return new SearchBlock(driver);
    }

    public boolean isProfileButtonPresent() {
        return profileButton.isPresent();
    }

    public boolean isVisitYourAccountPresent() {
        return visitYourAccountButton.isPresent();
    }

    public boolean isEmailBoxPresent() {
        return emailBox.isPresent();
    }

    public boolean isContinueButtonVisible() {
        return continueButton.isVisible();
    }

    public boolean isPasswordBoxPresent() {
        return passwordBox.isPresent();
    }

    public boolean isLoginButtonVisible() {
        return loginButton.isVisible();
    }

    public boolean isSearchBoxPresent() {
        return searchBox.isPresent();
    }

    public void clickOnClosePopUp() {
        this.popupButton.click();
    }

    public boolean isPopupVisible() {
        return popupButton.isVisible();
    }

    public WishlistPage clickOnWishListButton() {
        wishListButton.clickIfPresent();
        return new WishlistPage(driver);
    }
}
