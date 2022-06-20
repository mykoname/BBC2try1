import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class BBCOneTests {
    private static final WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setJavascriptEnabled(false);
        ChromeOptions javaCap = new ChromeOptions();
        javaCap.merge(dc);
        driver = new ChromeDriver(javaCap); //отключаю javascript и создаю драйвер с опциями
    }


    @Test
    public void testGetMainNewsName(){  // Part 1 test1
        BBCHomePage homePage = new BBCHomePage(driver);
        BBCNewsPage newsPage = homePage.NewsPageClick();
        String avaitedName = "Zelensky visits front-line cities in south Ukraine";
        assertLinesMatch(Collections.singletonList(avaitedName), Collections.singletonList(newsPage.nameOfHeadline()));
    }

    @Test
    public void testGetListSecondaryTitles(){   // Part 1 test2
        BBCHomePage homePage = new BBCHomePage(driver);
        BBCNewsPage newsPage = homePage.NewsPageClick();
        WebElement newsTopStoriesContainer = newsPage.driver.findElement(By.id("news-top-stories-container"));
        WebElement[] list = newsTopStoriesContainer.findElements(By.tagName("h3")).stream().toList().toArray(new WebElement[0]);
     int number = newsTopStoriesContainer.findElements(By.tagName("h3")).size();
        for (int i = 0; i<number-1; i++) {
                            System.out.println(list[i].getText());
            }
//        List<String> avaitedListOfTitles = Collections.singletonList("");
//                   newsPage.secondaryArticlesTitlesList();
//        List<String> actualListOfTitles = Collections.singletonList("");
//        Assertions.assertLinesMatch(avaitedListOfTitles, actualListOfTitles);
    }


    @AfterAll
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
