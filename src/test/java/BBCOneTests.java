import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BBCOneTests {
    private static final WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
//        Capabilities. //даю их
//        ChromeOptions javaCap = new ChromeOptions(!!!!!);
        //отключаю javascript и создаю драйвер с опциями
//        driver = new ChromeDriver(javaCap);
        driver = new ChromeDriver();
    }

    @Test
    public void testPopUpWait() throws InterruptedException {
     //   driver.get(Utils.BASE_URL);
        BBCHomePage homePage = new BBCHomePage(driver);
        BBCNewsPage newsPage = homePage.NewsPageClick();
        newsPage.clickPopUpCloseCross();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage); // Print Alert Message
        Thread.sleep(5000);
        alert.accept();


//        newsPage.closePopUp();
        newsPage.clickTopContainer();
    }

    @Test
    public void testFindBy(){
        driver.get(Utils.BASE_URL);
        BBCHomePage homePage = new BBCHomePage(driver);
//        BBCNewsPage newsPage = homePage.NewsPageClick();
//        newsPage.closePopUp();
//        newsPage.clickTopContainer();
//        newsPage.clickPopUpCloseCross();
//        newsPage.clickTopContainer();
        // newsPage.findh2Names();
//        int amount = driver.findElements(new By.ByTagName("h2")).size();
//        System.out.println(amount);

    }



    @Test
    public void testGetMainNewsName(){
        driver.get(Utils.BASE_URL);     //??: чи не варто  мені це та верхню змінну прописати в HomePage?
        BBCHomePage homePage = new BBCHomePage(driver);
//        BBCNewsPage newsPage = homePage.NewsPageClick();
//        newsPage.clickMainN();
//        String ttt = newsPage.GetMainNewsName();
//        System.out.println(ttt);
//        Assert.assertThat(home.getFirstParagraphText(), containsString("рыба"));
    }


//    @AfterAll
//    public static void cleanUp(){
//        driver.manage().deleteAllCookies();
//        driver.close();
//    }
}
