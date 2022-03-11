package com.solvd.carina;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.page.AccessoriesPage;
import com.solvd.carina.page.AdidasHomePage;
import com.solvd.carina.page.ResultPage;
import com.solvd.carina.page.components.FilterBlock;
import com.solvd.carina.page.components.SearchBlock;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdidasTest extends AbstractTest {

    @TestRailCases(testCasesId = "1")
    @Test(description = "Check 3 help buttons.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyHomePageOpeningTest() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(5), "Adidas home page is not opened.");

        ResultPage resultPage = new ResultPage(getDriver());

        Assert.assertTrue(adidasHomePage.isHeaderHelpButtonPresent(), "Header Help button is not present.");
        adidasHomePage.headerHelpButton();
        Assert.assertTrue(resultPage.helpContentTitleIsVisible(), "Help Content is missing.");

        /** "This Help button working on web, but it is invisible because it's for mobile version."
         *
        Assert.assertTrue(adidasHomePage.isFooterHelpButtonPresent(), "Footer Help button is not present.");
        adidasHomePage.footerHelpButton();
        Assert.assertTrue(resultPage.helpContentTitleIsVisible(), "Help Content is missing.");
        */

        Assert.assertTrue(adidasHomePage.isHelpAndCustomerServicePresent()
                , "Help & Customer Service button is not present.");
        adidasHomePage.helpAndCustomerServiceButton();
        Assert.assertTrue(resultPage.helpContentTitleIsVisible(), "Help Content is missing.");
    }

    @TestRailCases(testCasesId = "2")
    @Test(description = "Open the Adidas Home page and sign in to account.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkLoginToAccount() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(5), "Adidas home page is not opened.");

        Assert.assertTrue(adidasHomePage.profileButtonIsPresent(), "Profile button is not present.");
        adidasHomePage.profileButton();
        Assert.assertTrue(adidasHomePage.profileButtonIsClickable(), "Unable click on profile button.");

        Assert.assertTrue(adidasHomePage.emailBoxIsPresent(), "Email box is not present.");
        adidasHomePage.emailBox("poterin59@816qs.com");

        Assert.assertTrue(adidasHomePage.continueButtonIsPresent(), "Continue button is not present.");
        adidasHomePage.continueButton();

        Assert.assertTrue(adidasHomePage.passwordBoxIsPresent(), "Password box is not present.");
        adidasHomePage.passwordBox("12345Test");

        Assert.assertTrue(adidasHomePage.loginButtonIsPresent(), "Login button is not present.");
        adidasHomePage.logInButton();

        ResultPage resultPage = adidasHomePage.visitYourAccount();
        Assert.assertTrue(resultPage.homeUserStatusIsVisible(), "User status is missing.");
    }

    @TestRailCases(testCasesId = "3")
    @Test(description = "Open the Adidas Home page and use special character in search box.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkSpecialCharacter() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");

        Assert.assertTrue(adidasHomePage.searchBoxIsPresent(), "Search box is not visible.");
        SearchBlock searchBlock = adidasHomePage.clickSearchBox("@!?#$%&*\n");

        ResultPage resultPage = searchBlock.getProductResult();
        Assert.assertTrue(resultPage.searchNoContentTitleIsVisible(), "Search Title is missing.");
        Assert.assertTrue(resultPage.searchNoContentDescriptionIsVisible(), "Search description is missing.");
    }

    @TestRailCases(testCasesId = "4")
    @Test(description = "Open the wishlist page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkWishList() throws InterruptedException {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");

        ResultPage resultPage = adidasHomePage.clickOnWishListButton();

        Assert.assertTrue(resultPage.popupIsVisible(), "Popup button is not visible.");
        resultPage.closePopUp();
        Assert.assertFalse(resultPage.popupIsVisible(), "Popup button is visible.");

        Assert.assertTrue(resultPage.productListIsVisible(), "Result page is not opened.");

        int from = 0;
        int to = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from + "," + to + ")");
            Thread.sleep(1000);
            from = from + 500;
            to = to + 500;
        }
    }

    @TestRailCases(testCasesId = "5")
    @Test(description = "Open the Adidas Home page and search product.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkSearchBox() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");

        Assert.assertTrue(adidasHomePage.searchBoxIsPresent(), "Search box is not present.");
        SearchBlock searchBlock = adidasHomePage.clickSearchBox("cap");

        Assert.assertTrue(searchBlock.newFrameIsVisible(), "Result page is not opened.");
        ResultPage resultPage = searchBlock.clickOnCap();

        Assert.assertTrue(resultPage.popupIsVisible(), "Popup button is not visible.");
        resultPage.closePopUp();

        Assert.assertFalse(resultPage.productListIsVisible(), "Result page is empty.");
    }

    @TestRailCases(testCasesId = "6")
    @Test(description = "Using LowPrice to High filter.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyLowPriceToHigh() throws InterruptedException {
        Integer firstUnSort, firstSort;
        Integer secondUnSort, secondSort;
        Integer thirdUnSort, thirdSort;
        Integer fourthUnSort, fourthSort;

        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        int from = 0;
        int to = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from + "," + to + ")");
            Thread.sleep(1000);
            from = from + 500;
            to = to + 500;
        }

        firstUnSort = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSort = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSort = accessoriesPage.getProductPricesAsNumbers().get(5);
        fourthUnSort = accessoriesPage.getProductPricesAsNumbers().get(7);

        Assert.assertTrue(accessoriesPage.isAnyElementPresent(accessoriesPage.getFilterButton()),
                "Filter button is not visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();

        Assert.assertTrue(filterBlock.isLowPriceToHighButtonIsVisible(),
                "LowPrice to High button filter not visible.");
        filterBlock.clickLowPriceToHigh();

        ResultPage resultPage = filterBlock.clickApplyButton();

        Assert.assertTrue(resultPage.popupIsVisible(), "Popup button is not visible.");
        resultPage.closePopUp();
        Assert.assertFalse(resultPage.popupIsVisible(), "Popup button is visible.");

        int from1 = 0;
        int to1 = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from1 + "," + to1 + ")");
            Thread.sleep(1000);
            from1 = from1 + 500;
            to1 = to1 + 500;
        }

        firstSort = resultPage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSort, firstSort, "Products are equals.");

        secondSort = resultPage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSort, secondSort, "Products are equals.");

        thirdSort = resultPage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(thirdUnSort, thirdSort, "Products are equals.");

        fourthSort = resultPage.getResultPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSort, fourthSort, "Products are equals.");
    }

    @TestRailCases(testCasesId = "7")
    @Test(description = "Using the HighPrice to Low filter.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyHighPriceToLow() throws InterruptedException {
        Integer firstUnSort, firstSort;
        Integer secondUnSort, secondSort;
        Integer thirdUnSort, thirdSort;
        Integer fourthUnSort, fourthSort;

        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        int from = 0;
        int to = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from + "," + to + ")");
            Thread.sleep(1000);
            from = from + 500;
            to = to + 500;
        }

        firstUnSort = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSort = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSort = accessoriesPage.getProductPricesAsNumbers().get(5);
        fourthUnSort = accessoriesPage.getProductPricesAsNumbers().get(7);

        Assert.assertTrue(accessoriesPage.isAnyElementPresent(accessoriesPage.getFilterButton())
                , "Filter button isn't visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();

        Assert.assertTrue(filterBlock.isHighPriceToLowButtonIsVisible(), "Filter button isn't visible.");
        filterBlock.clickHighPriceToLow();

        ResultPage resultPage = filterBlock.clickApplyButton();

        Assert.assertTrue(resultPage.popupIsVisible(), "Popup button is not visible.");
        resultPage.closePopUp();
        Assert.assertFalse(resultPage.popupIsVisible(), "Popup button is visible.");

        int from1 = 0;
        int to1 = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from1 + "," + to1 + ")");
            Thread.sleep(1000);
            from1 = from1 + 500;
            to1 = to1 + 500;
        }

        firstSort = resultPage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSort, firstSort, "Products are equals.");

        secondSort = resultPage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSort, secondSort, "Products are equals.");

        thirdSort = resultPage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(thirdUnSort, thirdSort, "Products are equals.");

        fourthSort = resultPage.getResultPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSort, fourthSort, "Products are equals.");
    }

    @TestRailCases(testCasesId = "8")
    @Test(description = "Using the HighPrice to Low filter.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyTopSellers() throws InterruptedException {
        Integer firstUnSort, firstSort;
        Integer secondUnSort, secondSort;
        Integer thirdUnSort, thirdSort;
        Integer fourthUnSort, fourthSort;

        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        int from = 0;
        int to = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from + "," + to + ")");
            Thread.sleep(1000);
            from = from + 500;
            to = to + 500;
        }

        firstUnSort = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSort = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSort = accessoriesPage.getProductPricesAsNumbers().get(5);
        fourthUnSort = accessoriesPage.getProductPricesAsNumbers().get(7);

        Assert.assertTrue(accessoriesPage.isAnyElementPresent(accessoriesPage.getFilterButton())
                , "Filter button isn't visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();

        Assert.assertTrue(filterBlock.isTopSellersButtonIsVisible(), "Filter button isn't visible.");
        filterBlock.clickTopSellersButton();

        ResultPage resultPage = filterBlock.clickApplyButton();

        Assert.assertTrue(resultPage.popupIsVisible(), "Popup button is not visible.");
        resultPage.closePopUp();
        Assert.assertFalse(resultPage.popupIsVisible(), "Popup button is visible.");

        int from1 = 0;
        int to1 = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from1 + "," + to1 + ")");
            Thread.sleep(1000);
            from1 = from1 + 500;
            to1 = to1 + 500;
        }

        firstSort = resultPage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSort, firstSort, "Products are equals.");

        secondSort = resultPage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSort, secondSort, "Products are equals.");

        thirdSort = resultPage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(thirdUnSort, thirdSort, "Products are equals.");

        fourthSort = resultPage.getResultPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSort, fourthSort, "Products are equals.");
    }

    @TestRailCases(testCasesId = "9")
    @Test(description = "Adding product to wishlist from Accessories page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkAddToWishlist() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();

        accessoriesPage.addProductToWishlist();
    }
}
