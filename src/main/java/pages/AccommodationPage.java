package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigManager;
import utils.WaitUtils;

import java.util.List;

public class AccommodationPage extends BasePage {
    private final String url = ConfigManager.getFullUrl("accommodation.path");
    private final By checkInDateField = By.xpath("//a[@id='Citybreak_trigger_from']");
    private final By checkOutDateField = By.xpath("//a[@id='Citybreak_trigger_to']");
    private final By datePickerTable = By.xpath("//div[@id='cb-ui-datepicker-div']//table");
    private final By guestsDropdown = By.xpath("//select[@id='cb_numadults1']");
    private final By searchButton = By.xpath("//a[@id='CB_SearchButton']");

    public AccommodationPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAccommodationPage() {
        navigateTo(url);
    }

    /**
     * Selects the Check-In and Check-Out dates from the date picker on the page.
     *
     * @param checkInDate  the date to be selected as the Check-In date in the format "dd/MM/yyyy".
     * @param checkOutDate the date to be selected as the Check-Out date in the format "dd/MM/yyyy".
     * @throws IllegalArgumentException if either the Check-In or Check-Out date is null.
     */
    public void selectCheckInAndCheckOut(String checkInDate, String checkOutDate) {
        if (checkInDate == null || checkOutDate == null) {
            throw new IllegalArgumentException("Check-In and Check-Out dates cannot be null.");
        }
        click(checkInDateField);
        selectDateFromCalendar(find(datePickerTable), checkInDate);

        click(checkOutDateField);
        selectDateFromCalendar(find(datePickerTable), checkOutDate);
    }

    /**
     * Selects a specific date from the date picker calendar.
     *
     * @param datePicker   the WebElement representing the calendar (date picker).
     * @param dateToSelect the date to be selected, expected in the format "dd/MM/yyyy".
     *                     Only the day (dd) part is used for selection.
     */
    private void selectDateFromCalendar(WebElement datePicker, String dateToSelect) {
        List<WebElement> dateCells = datePicker.findElements(By.tagName("td"));

        for (WebElement cell : dateCells) {
            String cellText = cell.getText();
            if (cellText.equals(dateToSelect.split("/")[0])) {
                cell.click();
                break;
            }
        }
    }

    public void selectGuestsFromDropdownByIndex(int optionIndex) {
        selectFromDropdownByIndex(guestsDropdown, optionIndex);
    }

    public void clickSearchButtonAndWaitForTitle(String expectedTitle, int timeoutInSeconds) {
        click(searchButton);
        WaitUtils.waitForTitleToBe(driver, expectedTitle, timeoutInSeconds);
    }
}
