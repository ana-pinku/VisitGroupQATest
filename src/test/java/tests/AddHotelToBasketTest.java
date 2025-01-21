package tests;

import org.testng.annotations.Test;
import pages.BasketPage;
import pages.CookiePage;
import pages.AccommodationPage;
import pages.SearchResultsPage;
import utils.CustomAssertions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddHotelToBasketTest extends BaseTest {
    @Test
    public void verifyHotelIsAddedToBasketCorrectly() {
        // Initialize the necessary page objects
        AccommodationPage accommodationPage = new AccommodationPage(driver);
        CookiePage cookiePage = new CookiePage(driver);
        BasketPage basketPage = new BasketPage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        // TEST DATA: Prepare date format and calculate check-in and check-out dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate dayAfterTomorrow = tomorrow.plusDays(1);

        String checkInDate = tomorrow.format(formatter);
        String checkOutDate = dayAfterTomorrow.format(formatter);
        String yourBasketExpectedHeader = "YOUR BASKET";

        // TEST STEPS
        // Step 1: Navigate to the Accommodation page and accept cookies
        accommodationPage.navigateToAccommodationPage();
        cookiePage.acceptCookies();

        // Step 2: Select check-in and check-out dates
        // Expand the date pickers and set check-in for tomorrow and check-out for the day after tomorrow
        accommodationPage.selectCheckInAndCheckOut(checkInDate, checkOutDate);

        // Step 3: Select 2 adults from the guests dropdown
        accommodationPage.selectGuestsFromDropdownByIndex(1); // Index 1 corresponds to 2 adults

        // Step 4: Click the search button and wait for the search results page to load
        accommodationPage.clickSearchButtonAndWaitForTitle("Accommodations Hotels and Rooms Destination Gotland", 5);

        // Step 5: Retrieve the name and price of the first hotel in the search results
        String firstHotelName = searchResultsPage.getHotelName(1);
        String firstHotelPrice = searchResultsPage.getHotelPrice(1);

        // Step 6: Click the 'Book Now' button for the first search result
        searchResultsPage.clickBookNowAndWaitForBookButton(1);

        // Step 7: Click the 'Book' button for the first hotel proposal and wait for the Basket page to load
        searchResultsPage.clickBookButtonAndWaitForTitle(1,"Basket Destination Gotland");

        // Step 8: Validate the Basket page content
        // Assert that the header text matches the expected value
        CustomAssertions.assertEquals(basketPage.getYourBasketHeaderText(), yourBasketExpectedHeader, "The header text on the Basket page is not as expected!");

        // Assert that the first hotel name in the basket matches the selected hotel name
        CustomAssertions.assertEquals(basketPage.getHotelInBasketText(1), firstHotelName, "Basket Hotel name is not correct!");

        // Assert that the total price in the basket matches the selected hotel price
        CustomAssertions.assertEquals(basketPage.getTotalBasketPriceText(), firstHotelPrice, "Basket Total price is not correct!");
    }
}
