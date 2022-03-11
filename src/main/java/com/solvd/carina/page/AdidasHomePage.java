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
    private ExtendedWebElement helpAndCustomerService;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--tertiary profile_button_link___WQCT9 outlined-icon-color___1fd_i undefined']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//input[@id='login-register-auto-flow-input']")
    private ExtendedWebElement emailBox;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--primary gl-cta--full-width gl-vspace']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//input[@id='login-password']")
    private ExtendedWebElement passwordBox;

    @FindBy(xpath = "//button[contains(@class,'gl-cta gl-cta--primary') and contains(@data-auto-id,'login-form-login')]")
    private ExtendedWebElement logInButton;

    @FindBy(css = ".searchinput___zXLAR")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = "//span[@class='btn-clear-search-filler___2Qh5i']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='gl-wishlist-icon wishlist_button___3ppwb outlined-icon-color___2xwB3']")
    private ExtendedWebElement wishListButton;

    public AdidasHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public void headerHelpButton() {
        this.headerHelpButton.click();
    }

    public boolean isHeaderHelpButtonPresent() {
        return this.headerHelpButton.isPresent();
    }

    public void footerHelpButton() {
        this.footerHelpButton.click();
    }

    public boolean isFooterHelpButtonPresent() {
        return this.footerHelpButton.isPresent();
    }

    public void helpAndCustomerServiceButton() {
        this.helpAndCustomerService.click();
    }

    public boolean isHelpAndCustomerServicePresent() {
        return this.helpAndCustomerService.isPresent();
    }

    public void profileButton() {
        this.profileButton.clickIfPresent();
    }

    /**
     * email: poterin59@816qs.com
     */
    public void emailBox(String email) {
        this.emailBox.clickIfPresent();
        this.emailBox.type(email);
    }

    public void continueButton() {
        this.continueButton.clickIfPresent();
    }

    /**
     * Password: 12345Test
     */
    public void passwordBox(String password) {
        this.passwordBox.clickIfPresent();
        this.passwordBox.type(password);
    }

    public void logInButton() {
        this.logInButton.clickIfPresent();
    }

    public SearchBlock clickSearchBox(String productName) {
        this.searchBox.clickIfPresent();
        this.searchBox.type(productName);
        return new SearchBlock(driver);
    }

    public ResultPage clickOnWishListButton() {
        this.wishListButton.clickIfPresent();
        return new ResultPage(driver);
    }

    public boolean isProfileButtonPresent() {
        return this.profileButton.isPresent();
    }

    public boolean isEmailBoxPresent() {
        return this.emailBox.isPresent();
    }

    public boolean isContinueButtonPresent() {
        return this.continueButton.isPresent();
    }

    public boolean isPasswordBoxPresent() {
        return this.passwordBox.isPresent();
    }

    public boolean isLoginButtonPresent() {
        return this.logInButton.isPresent();
    }

    public boolean isSearchBoxPresent() {
        return this.searchBox.isPresent();
    }
}
