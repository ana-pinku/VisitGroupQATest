# VisitGroupQATest

## Project Description
This project contains an automated test framework designed to verify key functionalities of a hotel booking website. Specifically, it includes a test case that ensures a selected hotel is correctly added to the user's basket. The framework follows the Page Object Model (POM) design pattern to enhance maintainability and readability.

## Technologies and Tools Used
- **Programming Language**: Java 23
- **Testing Framework**: TestNG 7.7.1
- **Browser Automation**: Selenium 4.13.0
- **Dependency Management**: Maven
- **WebDriver Management**: WebDriverManager 5.5.3
- **Logging**: Logback

## Project Structure
```
VisitGroupQATest
|-- src
|   |-- main
|   |   |-- java
|   |       |-- pages
|           |-- utils
|   |-- test
|       |-- java
|           |-- tests
|-- pom.xml
```
- **pages/**: Contains Page Object classes (e.g., `AccommodationPage`, `BasketPage`, `CookiePage`, `SearchResultsPage`).
- **tests/**: Contains test classes (e.g., `AddHotelToBasketTest`).
- **utils/**: Contains utility classes such as `CustomAssertions`.
- **pom.xml**: Defines Maven dependencies and build configuration.

## Installation and Setup
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd VisitGroupQATest
   ```

2. **Install Dependencies**
   Ensure Maven is installed, then run:
   ```bash
   mvn clean install
   ```

3. **Run the Tests**
   Use the following Maven command to execute the tests:
   ```bash
   mvn test
   ```

## Adding New Tests or Pages
1. **Create a New Test Class**
    - Place your test class in the `tests` package.
    - Extend `BaseTest` to inherit setup and teardown methods.

2. **Create a New Page Object Class**
    - Place your Page Object class in the `pages` package.
    - Define methods representing actions and elements on the page.

## Example Test Class
```java
@Test
public void verifyHotelIsAddedToBasketCorrectly() {
    AccommodationPage accommodationPage = new AccommodationPage(driver);
    accommodationPage.navigateToAccommodationPage();
    // Further test steps...
}
```

## Maven Configuration
The project uses the following Maven dependencies:
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.13.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.7.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.5.3</version>
    </dependency>
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.5.16</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```



