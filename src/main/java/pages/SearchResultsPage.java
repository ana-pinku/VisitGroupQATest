package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SearchResultsPage extends BasePage {

    private By getHotelPriceLocator(int index) {
        return By.xpath("(//div[@id='cb_js_search_result']/div[2]//h2)[" + index + "]");
    }

    private By getHotelNameLocator(int index) {
        return By.xpath("(//div[@id='cb_js_search_result']/div[2]//h2)[" + (index * 2) + "]");
    }

    private By getBookNowButtonLocator(int index) {
        return By.xpath("(//a[@class='Citybreak_Button cb-btn cb-btn-primary cb_expandbutton cb-test-book-now '])[" + index + "]");
    }

    private By getBookButtonLocator(int index) {
        return By.xpath("(//input[@value='Book'])[" + index + "]");
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getHotelName(int index) {
        return find(getHotelNameLocator(index)).getText();
    }

    public String getHotelPrice(int index) {
        return find(getHotelPriceLocator(index)).getText();
    }

    public void clickBookNowAndWaitForBookButton(int index) {
        click(getBookNowButtonLocator(index));
        WaitUtils.waitForElementToBeVisible(driver, getBookButtonLocator(index), 5);
    }

    public void clickBookButtonAndWaitForTitle(int index, String expectedTitle) {
        click(getBookButtonLocator(index));
        WaitUtils.waitForTitleToBe(driver, expectedTitle, 10);
    }
}

