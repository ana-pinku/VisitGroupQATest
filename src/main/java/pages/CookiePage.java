package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CookiePage extends BasePage {
    private final By acceptCookiesButton = By.xpath("//button[@id='updateButton']/following-sibling::button[1]");

    public CookiePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        WaitUtils.waitForElementToBeClickable(driver, acceptCookiesButton, 5);
        click(acceptCookiesButton);
    }
}

