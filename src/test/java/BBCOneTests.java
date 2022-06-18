import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class BBCOneTests {
    private static final WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setJavascriptEnabled(false);
        //   Capabilities. //даю их
        ChromeOptions javaCap = new ChromeOptions();
        javaCap.merge(dc);
        //отключаю javascript и создаю драйвер с опциями
        driver = new ChromeDriver(javaCap);
//        driver = new ChromeDriver();
    }

//    @Test
//    public void testPopUpWait() throws InterruptedException {
//     //   driver.get(Utils.BASE_URL);
//        BBCHomePage homePage = new BBCHomePage(driver);
//        BBCNewsPage newsPage = homePage.NewsPageClick();
//        newsPage.clickPopUpCloseCross();
//        Thread.sleep(5000);
//        Alert alert = driver.switchTo().alert(); // switch to alert
//        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
//        System.out.println(alertMessage); // Print Alert Message
//        Thread.sleep(5000);
//        alert.accept();
//
//
////        newsPage.closePopUp();
//        newsPage.clickTopContainer();
//    }

//    @Test
//    public void testFindBy(){
//        driver.get(Utils.BASE_URL);
//        BBCHomePage homePage = new BBCHomePage(driver);
////        BBCNewsPage newsPage = homePage.NewsPageClick();
////        newsPage.closePopUp();
////        newsPage.clickTopContainer();
////        newsPage.clickPopUpCloseCross();
////        newsPage.clickTopContainer();
//        // newsPage.findh2Names();
////        int amount = driver.findElements(new By.ByTagName("h2")).size();
////        System.out.println(amount);
//
//    }



    @Test
    public void testGetMainNewsName(){
        BBCHomePage homePage = new BBCHomePage(driver);
        BBCNewsPage newsPage = homePage.NewsPageClick();
        String avaitedName = "Zelensky visits front-line cities in south Ukraine";
        assertLinesMatch(Collections.singletonList(avaitedName), Collections.singletonList(newsPage.nameOfHeadline()));

    }


    @AfterAll
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
