import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class JUnitTestDriver {

    @Test
    void testOpenWebsitegoogle() {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement searchInput = driver.findElement(By.name("q"));

        String expectedText = "PWS NPRU";
        searchInput.sendKeys(expectedText);
        searchInput.submit();

        // Wait for the search results page to load (you might need to add some waits here)
        // For simplicity, let's assume the page has loaded properly before checking the results.

        // Find the search result element that contains the expected text
        WebElement searchResult = driver.findElement(By.xpath("//*[contains(text(), '" + expectedText + "')]"));

        // Assert that the search result contains the expected text
        assertTrue(searchResult.isDisplayed(), "Search result does not contain the expected text: " + expectedText);

        driver.quit();
    }
}

