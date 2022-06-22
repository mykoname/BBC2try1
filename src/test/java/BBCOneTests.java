import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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
        List<String> avaitedListOfTitles = List.of(
                "Russia warns Lithuania over rail transit blockade",
                        "Election officials detail Trump followers' threats",
                        "Mining firm Glencore admits UK bribery charges",
                        "Fans 'treated like animals' at Champions League final",
                        "In pictures: Americans face extreme temperatures",
                        "Elon Musk's daughter cuts ties with her father",
                        "French court upholds ban on burkini swimsuits",
                        "Strava app flaw revealed runs at secret bases",
                        "Bangladesh: Deadly floods leave millions displaced",
                        "X Factor star's fiancee dies on wedding day",
                        "Russian journalist's Nobel medal sells for $103.5m",
                        "Policeman dismissed over attack on female diners",
                        "EasyJet Spain cabin crew set to strike in July");
        Assertions.assertLinesMatch(avaitedListOfTitles, newsPage.secondaryArticlesTitlesList());
    }

    @Test
    public void testCategoryAndFirstArticle(){   // Part1 test3
        BBCHomePage homePage = new BBCHomePage(driver);
        BBCNewsPage newsPage = homePage.NewsPageClick();
        String stringForSearch = newsPage.storedSearchTerm();
        BBCSearchPage searchPage = newsPage.startSearchPage();
        System.out.println(searchPage.firstSearchResult(stringForSearch));


    }


    @AfterAll
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
