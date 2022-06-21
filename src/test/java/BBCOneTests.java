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
        newsPage.secondaryArticlesTitlesList();
//       List<WebElement> listOfTitles = newsPage.driver.findElements(By.xpath("//div[@id ='news-top-stories-container']//a[@href]//h3"));
//        System.out.println(newsPage.driver.findElements(By.xpath("//div[@id ='news-top-stories-container']//a[@href]//h3")).size());
//     int number = newsPage.driver.findElements(By.tagName("h3")).size();
//        StringBuilder[] puredTitles = new StringBuilder[number];
//        for (int i = 2; i<number; i++) {
//             if (listOfTitles.get(i).isDisplayed())
//                 {
//                 System.out.println(listOfTitles.get(i).getText());
//                 puredTitles[i-2] = new StringBuilder(listOfTitles.get(i).getText());
//                 System.out.println(puredTitles[i-2]);
//                 }
//            }

//        List<String> avaitedListOfTitles = List.of("Row erupts over blocked goods at Russian territory",
//                "India floods destroy millions of homes and dreams",
//                "Ben Stiller describes 'distressing' Ukraine visit",
//                "Policeman dismissed over attack on female diners",
//                "UN sexual abuse claims 'must be investigated'",
//                "Iconic Hong Kong floating restaurant sinks",
//                "The woman who could upend US abortion rights",
//                "Photos of Prince William mark duke's 40th birthday",
//                "Russian journalist's Nobel medal sells for $103.5m");
//               //                   newsPage.secondaryArticlesTitlesList();
//        Assertions.assertLinesMatch(avaitedListOfTitles, secondaryTitlesListOut);
    }


    @AfterAll
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
