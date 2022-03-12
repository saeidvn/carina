package com.solvd.carina.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//h4[@class='nohits_title___2jjLy']")
    private ExtendedWebElement searchNoContentTitle;

    @FindBy(xpath = "//p[@class='gl-body--s']")
    private ExtendedWebElement searchNoContentDescription;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchNoContentTitleVisible() {
        return searchNoContentTitle.isVisible();
    }

    public boolean isSearchNoContentDescriptionVisible() {
        return searchNoContentDescription.isVisible();
    }
}
