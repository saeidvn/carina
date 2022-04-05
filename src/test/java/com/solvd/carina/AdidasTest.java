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
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class AdidasTest extends AbstractTest {

    @TestRailCases(testCasesId = "1")
    @Test(description = "Check 2 help button.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkHelpButtons() {
        SoftAssert softAssert = new SoftAssert();
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        softAssert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");
        softAssert.assertTrue(adidasHomePage.isHeaderHelpButtonPresent(), "Header Help button is not present.");
        HelpPage helpPage = adidasHomePage.clickOnHeaderHelpButton();
        softAssert.assertTrue(helpPage.isHelpContentTitleVisible(), "Help Content is missing.");
        softAssert.assertTrue(helpPage.isAdidasHomePageButtonPresent(), "Adidas home page button is not visible.");
        helpPage.clickOnAdidasHomePageButton();
        softAssert.assertTrue(adidasHomePage.isPopupVisible(), "Popup is not visible.");
        adidasHomePage.clickOnClosePopUp();
        softAssert.assertFalse(adidasHomePage.isPopupVisible(), "Popup is visible.");
        softAssert.assertTrue(adidasHomePage.isHelpAndCustomerServicePresent()
                , "Help & Customer Service button is not present.");
        helpPage = adidasHomePage.clickOnHelpAndCustomerServiceButton();
        softAssert.assertTrue(helpPage.isHelpContentTitleVisible(), "Help Content is missing.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "2")
    @Test(description = "Open the Adidas home page and login to account.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkLoginToAccount() {
        SoftAssert softAssert = new SoftAssert();
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        softAssert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");
        softAssert.assertTrue(adidasHomePage.isProfileButtonPresent(), "Profile button is not present.");
        adidasHomePage.clickOnProfileButton();
        softAssert.assertTrue(adidasHomePage.isEmailBoxPresent(), "Email box is not present.");
        adidasHomePage.typeEmailInBox(R.CONFIG.get("email"));
        softAssert.assertTrue(adidasHomePage.isContinueButtonVisible(), "Continue button is not present.");
        adidasHomePage.clickOnContinueButton();
        softAssert.assertTrue(adidasHomePage.isPasswordBoxPresent(), "Password box is not present.");
        adidasHomePage.typePasswordInBox(R.CONFIG.get("password"));
        softAssert.assertTrue(adidasHomePage.isLoginButtonVisible(), "Login button is not present.");
        adidasHomePage.clickOnLoginButton();
        softAssert.assertTrue(adidasHomePage.isVisitYourAccountPresent(), "");
        MyAccountPage myAccountPage = adidasHomePage.clickOnVisitYourAccountButton();
        softAssert.assertTrue(myAccountPage.isHomeUserStatusVisible(), "User status is missing.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "3")
    @Test(description = "Open the Adidas home page and search special character in search box.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkSearchSpecialCharacter() {
        SoftAssert softAssert = new SoftAssert();
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        softAssert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");
        softAssert.assertTrue(adidasHomePage.isSearchBoxPresent(), "Search box is not visible.");
        SearchBlock searchBlock = adidasHomePage.typeSpecialCharacter(R.CONFIG.get("special_character"));
        SearchResultPage resultPage = searchBlock.noResultForSearch();
        softAssert.assertTrue(resultPage.isSearchNoContentTitleVisible(), "Search Title is missing.");
        softAssert.assertTrue(resultPage.isSearchNoContentDescriptionVisible(), "Search description is missing.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "4")
    @Test(description = "Open Adidas home page and click on wishlist button to open the wishlist page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkWishListButton() {
        SoftAssert softAssert = new SoftAssert();
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        softAssert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");
        WishlistPage wishlistPage = adidasHomePage.clickOnWishListButton();
        softAssert.assertTrue(wishlistPage.isPopupVisible(), "Popup button is not visible.");
        wishlistPage.clickOnClosePopUp();
        softAssert.assertFalse(wishlistPage.isPopupVisible(), "Popup button is visible.");
        softAssert.assertTrue(wishlistPage.isProductListEmpty(), "Result page is not opened.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "5")
    @Test(description = "Open the Adidas Home page and search product.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkSearchSomeProduct() {
        SoftAssert softAssert = new SoftAssert();
        AdidasHomePage adidasHomePage = new AdidasHomePage(getDriver());
        adidasHomePage.open();
        softAssert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page is not opened.");
        softAssert.assertTrue(adidasHomePage.isSearchBoxPresent(), "Search box is not present.");
        SearchBlock searchBlock = adidasHomePage.searchProduct("cap");
        softAssert.assertTrue(searchBlock.isNewFrameVisible(), "Result page is not opened.");
        ProductListResultPage searchResultPage = searchBlock.clickOnCapButton();
        softAssert.assertTrue(searchResultPage.isPopupVisible(), "Popup button is not visible.");
        searchResultPage.clickOnClosePopUp();
        softAssert.assertFalse(searchResultPage.isProductListEmpty(), "Search result page is empty.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "6")
    @Test(description = "Using LowPrice to HighPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyLowPriceToHighPriceFilter() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        softAssert.assertTrue(accessoriesPage.isPageOpened(), "Accessories page is not opened.");
        accessoriesPage.scrollDownPage();
        int firstUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(3);
        int thirdUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(5);
        int fourthUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(2);
        softAssert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button is not visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();
        softAssert.assertTrue(filterBlock.isLowPriceToHighPriceButtonPresent(),
                "LowPrice to HighPrice filter button is not visible.");
        filterBlock.clickOnLowPriceToHighButton();
        softAssert.assertTrue(filterBlock.isApplyButtonPresent(), "Apply button is not present.");
        ProductListResultPage lowPriceToHighPricePage = filterBlock.clickOnApplyButton();
        softAssert.assertTrue(lowPriceToHighPricePage.isPopupVisible(), "Popup button is not visible.");
        lowPriceToHighPricePage.clickOnClosePopUp();
        softAssert.assertFalse(lowPriceToHighPricePage.isPopupVisible(), "Popup button is visible.");
        lowPriceToHighPricePage.scrollDownPage();
        int firstSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(0);
        softAssert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First Products are equals.");
        int secondSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(3);
        softAssert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second Products are equals.");
        int thirdSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(5);
        softAssert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third Products are equals.");
        int fourthSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(2);
        softAssert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth Products are equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "7")
    @Test(description = "Using the HighPrice to LowPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyHighPriceToLowPriceFilter() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        softAssert.assertTrue(accessoriesPage.isPageOpened(), "Accessories page is not opened.");
        accessoriesPage.scrollDownPage();
        int firstUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(3);
        int thirdUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(5);
        int fourthUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(6);
        softAssert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();
        softAssert.assertTrue(filterBlock.isHighPriceToLowPriceButtonPresent(),
                "HighPrice to LowPrice filter button is not visible.");
        filterBlock.clickOnHighPriceToLowButton();
        softAssert.assertTrue(filterBlock.isApplyButtonPresent(), "Apply button is not present.");
        ProductListResultPage highPriceToLowPricePage = filterBlock.clickOnApplyButton();
        softAssert.assertTrue(highPriceToLowPricePage.isPopupVisible(), "Popup button is not visible.");
        highPriceToLowPricePage.clickOnClosePopUp();
        softAssert.assertFalse(highPriceToLowPricePage.isPopupVisible(), "Popup button is visible.");
        highPriceToLowPricePage.scrollDownPage();
        int firstSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(0);
        softAssert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First Products are equals.");
        int secondSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(3);
        softAssert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second Products are equals.");
        int thirdSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(5);
        softAssert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third Products are equals.");
        int fourthSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(6);
        softAssert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth Products are equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "8")
    @Test(description = "Using the TopSellers filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void verifyTopSellersFilter() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        softAssert.assertTrue(accessoriesPage.isPageOpened(), "Accessories page is not opened.");
        accessoriesPage.scrollDownPage();
        int firstUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(3);
        int thirdUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(6);
        int fourthUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(8);
        softAssert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
        FilterBlock filterBlock = accessoriesPage.clickFilterButton();
        softAssert.assertTrue(filterBlock.isTopSellersButtonPresent(),
                "TopSellers filter button is not visible.");
        filterBlock.clickOnTopSellersButton();
        softAssert.assertTrue(filterBlock.isApplyButtonPresent(), "Apply button is not present.");
        ProductListResultPage topSellersPage = filterBlock.clickOnApplyButton();
        softAssert.assertTrue(topSellersPage.isPopupVisible(), "Popup button is not visible.");
        topSellersPage.clickOnClosePopUp();
        softAssert.assertFalse(topSellersPage.isPopupVisible(), "Popup button is visible.");
        topSellersPage.scrollDownPage();
        int firstSortProduct = topSellersPage.getResultPricesAsNumbers().get(0);
        softAssert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First Products are equals.");
        int secondSortProduct = topSellersPage.getResultPricesAsNumbers().get(3);
        softAssert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second Products are equals.");
        int thirdSortProduct = topSellersPage.getResultPricesAsNumbers().get(6);
        softAssert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third Products are equals.");
        int fourthSortProduct = topSellersPage.getResultPricesAsNumbers().get(8);
        softAssert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth Products are equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "9")
    @Test(description = "Adding product to wishlist from Accessories page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkAddProductToWishlist() {
        SoftAssert softAssert = new SoftAssert();
        AccessoriesPage accessoriesPage = new AccessoriesPage(getDriver());
        accessoriesPage.open();
        softAssert.assertTrue(accessoriesPage.isPageOpened(), "Accessories page is not opened.");
        List<Integer> indexOfProducts =
                Arrays.asList(1, 2, 3);
        for(int indexOfProduct :  indexOfProducts){
            accessoriesPage.addProductToWishList(indexOfProduct);
        }
        softAssert.assertTrue(accessoriesPage.isPopupVisible(), "Popup button is not visible.");
        accessoriesPage.clickOnClosePopUp();
        softAssert.assertFalse(accessoriesPage.isPopupVisible(), "Popup button not visible.");
        ProductListResultPage wishlistResult = accessoriesPage.clickOnWishListButton();
        softAssert.assertFalse(accessoriesPage.isWishlistListEmpty(), "Wishlist page is empty.");
        softAssert.assertTrue(wishlistResult.isPopupVisible(), "Popup button is not visible.");
        wishlistResult.clickOnClosePopUp();
        softAssert.assertFalse(wishlistResult.isPopupVisible(), "Popup button not visible.");
    }
}
