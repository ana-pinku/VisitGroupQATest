package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class BasketPage extends BasePage {

    private final By yourBasketHeader = By.xpath("//div[@class='cb-page-new']//h1");
    private final By totalBasketPrice = By.xpath("//div[@class='cb-summary-inline']//div[@class='cb-pricing']//b[2]");
    private By getHotelInBasketLocator(int index) {
        return By.xpath("(//div[@class='cb-ptg']//div//h2//a)[" + index + "]");
    }

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getYourBasketHeaderText() {
        return find(yourBasketHeader).getText();
    }

    public String getHotelInBasketText(int index) {
        By hotelLocator = getHotelInBasketLocator(index);
        WaitUtils.waitForElementToBeVisible(driver, hotelLocator, 5);
        return find(hotelLocator).getText();
    }

    public String getTotalBasketPriceText() {
        WaitUtils.waitForElementToBeVisible(driver, totalBasketPrice, 5);
        return find(totalBasketPrice).getText();
    }
}

