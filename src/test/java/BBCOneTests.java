import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BBCOneTests {
    private static final WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @Test
    public void testGetMainNewsName() {
        BBCHomePage homePage = new BBCHomePage(driver, Utils.BASE_URL);
        BBCNewsPage newsPage = homePage.NewsPageClick();
        Assertions.assertEquals("Zelensky visits front-line cities in south Ukraine", newsPage.getTopStoryTitle());
    }

    @AfterAll
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
