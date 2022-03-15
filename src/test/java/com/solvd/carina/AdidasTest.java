package com.solvd.carina;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.page.*;
import com.solvd.carina.page.components.FilterBlock;
import com.solvd.carina.page.components.SearchBlock;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AdidasTest extends AbstractTest {

    @TestRailCases(testCasesId = "1")
    @Test(description = "Check 2 help button.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkHelpButtons() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(5), "Adidas home page is not opened.");

        Assert.assertTrue(adidasHomePage.isHeaderHelpButtonPresent(), "Header Help button is not present.");
        HelpPage helpPage = adidasHomePage.clickOnHeaderHelpButton();
        Assert.assertTrue(helpPage.isHelpContentTitleVisible(), "Help Content is missing.");

        Assert.assertTrue(helpPage.isAdidasHomePageButtonPresent(), "Adidas home page button is not visible.");
        helpPage.clickOnAdidasHomePageButton();

        Assert.assertTrue(adidasHomePage.isPopupVisible(), "Popup is not visible.");
        adidasHomePage.clickOnClosePopUp();
        Assert.assertFalse(adidasHomePage.isPopupVisible(), "Popup is visible.");

        Assert.assertTrue(adidasHomePage.isHelpAndCustomerServicePresent()
                , "Help & Customer Service button is not present.");
        helpPage = adidasHomePage.clickOnHelpAndCustomerServiceButton();
        Assert.assertTrue(helpPage.isHelpContentTitleVisible(), "Help Content is missing.");
    }

    @TestRailCases(testCasesId = "2")
    @Test(description = "Open the Adidas home page and login to account.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkLoginToAccount() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(5), "Adidas home page is not opened.");

        Assert.assertTrue(adidasHomePage.isProfileButtonPresent(), "Profile button is not present.");
        adidasHomePage.clickOnProfileButton();

        Assert.assertTrue(adidasHomePage.isEmailBoxPresent(), "Email box is not present.");
        adidasHomePage.typeEmailInBox(R.CONFIG.get("email"));

        Assert.assertTrue(adidasHomePage.isContinueButtonVisible(), "Continue button is not present.");
        adidasHomePage.clickOnContinueButton();

        Assert.assertTrue(adidasHomePage.isPasswordBoxPresent(), "Password box is not present.");
        adidasHomePage.typePasswordInBox(R.CONFIG.get("password"));

        Assert.assertTrue(adidasHomePage.isLoginButtonVisible(), "Login button is not present.");
        adidasHomePage.clickOnLoginButton();

        Assert.assertTrue(adidasHomePage.isVisitYourAccountPresent(), "");
        MyAccountPage myAccountPage = adidasHomePage.clickOnVisitYourAccountButton();
        Assert.assertTrue(myAccountPage.isHomeUserStatusVisible(), "User status is missing.");
    }

    @TestRailCases(testCasesId = "3")
    @Test(description = "Open the Adidas home page and search special character in search box.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkSearchSpecialCharacter() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");

        Assert.assertTrue(adidasHomePage.isSearchBoxPresent(), "Search box is not visible.");
        SearchBlock searchBlock = adidasHomePage.typeSpecialCharacter(R.CONFIG.get("special_character"));

        SearchResultPage resultPage = searchBlock.noResultForSearch();
        Assert.assertTrue(resultPage.isSearchNoContentTitleVisible(), "Search Title is missing.");
        Assert.assertTrue(resultPage.isSearchNoContentDescriptionVisible(), "Search description is missing.");
    }

    @TestRailCases(testCasesId = "4")
    @Test(description = "Open Adidas home page and click on wishlist button to open the wishlist page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkWishListButton() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");

        WishlistPage wishlistPage = adidasHomePage.clickOnWishListButton();

        Assert.assertTrue(wishlistPage.isPopupVisible(), "Popup button is not visible.");
        wishlistPage.clickOnClosePopUp();
        Assert.assertFalse(wishlistPage.isPopupVisible(), "Popup button is visible.");

        Assert.assertTrue(wishlistPage.isProductListEmpty(), "Result page is not opened.");
    }

    @TestRailCases(testCasesId = "5")
    @Test(description = "Open the Adidas Home page and search product.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkSearchSomeProduct() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");

        Assert.assertTrue(adidasHomePage.isSearchBoxPresent(), "Search box is not present.");
        SearchBlock searchBlock = adidasHomePage.searchProduct("cap");

        Assert.assertTrue(searchBlock.isNewFrameVisible(), "Result page is not opened.");
        ProductListResultPage searchResultPage = searchBlock.clickOnCapButton();

        Assert.assertTrue(searchResultPage.isPopupVisible(), "Popup button is not visible.");
        searchResultPage.clickOnClosePopUp();

        Assert.assertFalse(searchResultPage.isProductListEmpty(), "Search result page is empty.");
    }

    @TestRailCases(testCasesId = "6")
    @Test(description = "Using LowPrice to HighPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyLowPriceToHighPriceFilter() throws InterruptedException {
        Integer firstUnSortProduct, firstSortProduct;
        Integer secondUnSortProduct, secondSortProduct;
        Integer thirdUnSortProduct, thirdSortProduct;
        Integer fourthUnSortProduct, fourthSortProduct;

        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        accessoriesPage.scrollDownPage();

        firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);
        fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(7);

        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button is not visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();

        Assert.assertTrue(filterBlock.isLowPriceToHighPriceButtonPresent(),
                "LowPrice to HighPrice filter button is not visible.");
        filterBlock.clickOnLowPriceToHighButton();

        Assert.assertTrue(filterBlock.isApplyButtonPresent(), "Apply button is not present.");
        ProductListResultPage lowPriceToHighPricePage = filterBlock.clickOnApplyButton();

        Assert.assertTrue(lowPriceToHighPricePage.isPopupVisible(), "Popup button is not visible.");
        lowPriceToHighPricePage.clickOnClosePopUp();
        Assert.assertFalse(lowPriceToHighPricePage.isPopupVisible(), "Popup button is visible.");

        lowPriceToHighPricePage.scrollDownPage();

        firstSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "Products are equals.");

        secondSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Products are equals.");

        thirdSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Products are equals.");

        fourthSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Products are equals.");
    }

    @TestRailCases(testCasesId = "7")
    @Test(description = "Using the HighPrice to LowPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyHighPriceToLowPriceFilter() throws InterruptedException {
        Integer firstUnSortProduct, firstSortProduct;
        Integer secondUnSortProduct, secondSortProduct;
        Integer thirdUnSortProduct, thirdSortProduct;
        Integer fourthUnSortProduct, fourthSortProduct;

        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        accessoriesPage.scrollDownPage();

        firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);
        fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(7);

        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();

        Assert.assertTrue(filterBlock.isHighPriceToLowPriceButtonPresent(),
                "HighPrice to LowPrice filter button is not visible.");
        filterBlock.clickOnHighPriceToLowButton();

        Assert.assertTrue(filterBlock.isApplyButtonPresent(), "Apply button is not present.");
        ProductListResultPage highPriceToLowPricePage = filterBlock.clickOnApplyButton();

        Assert.assertTrue(highPriceToLowPricePage.isPopupVisible(), "Popup button is not visible.");
        highPriceToLowPricePage.clickOnClosePopUp();
        Assert.assertFalse(highPriceToLowPricePage.isPopupVisible(), "Popup button is visible.");

        highPriceToLowPricePage.scrollDownPage();

        firstSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "Products are equals.");

        secondSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Products are equals.");

        thirdSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Products are equals.");

        fourthSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Products are equals.");
    }

    @TestRailCases(testCasesId = "8")
    @Test(description = "Using the TopSellers filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyTopSellersFilter() throws InterruptedException {
        Integer firstUnSortProduct, firstSortProduct;
        Integer secondUnSortProduct, secondSortProduct;
        Integer thirdUnSortProduct, thirdSortProduct;
        Integer fourthUnSortProduct, fourthSortProduct;

        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        accessoriesPage.scrollDownPage();

        firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(6);
        fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(7);

        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();

        Assert.assertTrue(filterBlock.isTopSellersButtonPresent(),
                "TopSellers filter button is not visible.");
        filterBlock.clickOnTopSellersButton();

        Assert.assertTrue(filterBlock.isApplyButtonPresent(), "Apply button is not present.");
        ProductListResultPage topSellersPage = filterBlock.clickOnApplyButton();

        Assert.assertTrue(topSellersPage.isPopupVisible(), "Popup button is not visible.");
        topSellersPage.clickOnClosePopUp();
        Assert.assertFalse(topSellersPage.isPopupVisible(), "Popup button is visible.");

        topSellersPage.scrollDownPage();

        firstSortProduct = topSellersPage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "Products are equals.");

        secondSortProduct = topSellersPage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Products are equals.");

        thirdSortProduct = topSellersPage.getResultPricesAsNumbers().get(6);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Products are equals.");

        fourthSortProduct = topSellersPage.getResultPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Products are equals.");
    }

    @TestRailCases(testCasesId = "9")
    @Test(description = "Adding product to wishlist from Accessories page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkAddProductToWishlist() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        List<Integer> indexOfProducts =
                Arrays.asList(1, 2, 3);
        for(int indexOfProduct :  indexOfProducts){
            accessoriesPage.addProductToWishList(indexOfProduct);
        }

        Assert.assertTrue(accessoriesPage.isPopupVisible(), "Popup button is not visible.");
        accessoriesPage.clickOnClosePopUp();
        Assert.assertFalse(accessoriesPage.isPopupVisible(), "Popup button not visible.");

        ProductListResultPage wishlistResult = accessoriesPage.clickOnWishListButton();
        Assert.assertFalse(accessoriesPage.isWishlistListEmpty(), "Wishlist page is empty.");

        Assert.assertTrue(wishlistResult.isPopupVisible(), "Popup button is not visible.");
        wishlistResult.clickOnClosePopUp();
        Assert.assertFalse(wishlistResult.isPopupVisible(), "Popup button not visible.");
    }
}
