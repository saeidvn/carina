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

    public AccessoriesPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("AccessoriesPage_url"));
    }

    public FilterBlock clickFilterButton() {
        filterButton.clickIfPresent();
        return new FilterBlock(driver);
    }

    public ExtendedWebElement getFilterButton() {
        return filterButton;
    }

    public List<String> getProductPricesAsStrings() {
        return this.productPrices.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getProductPricesAsNumbers() {
        return this.getProductPricesAsStrings().stream()
                .map(price -> price.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
