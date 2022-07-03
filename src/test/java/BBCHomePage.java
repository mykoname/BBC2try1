import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class BBCHomePage extends BBCPageObject {
    @FindBy(linkText = "News")
    private WebElement NewsPage;
    @FindBy(linkText = "Sport")
    private WebElement sportPage;


    public BBCHomePage(WebDriver driver) {
        super(driver, Utils.BASE_URL);
//        WaitElement("#orb-header > div > nav.orbit-header-links.international");
//        driver.get(Utils.BASE_URL);
    }
    public BBCHomePage(WebDriver driver, String URL) {
        super(driver, URL);
//        WaitElement("#orb-header > div > nav.orbit-header-links.international");
    }

//    public String getWaitSelector(){
//        return  "#orb-contentinfo > div > div > ul";
//    }

    public BBCNewsPage NewsPageClick(){
        this.NewsPage.click();
//        BBCNewsPage newsPage = new BBCNewsPage(driver);
        return new BBCNewsPage(driver);
    }

    public BBCSportPage sportPageClick(){
        this.sportPage.click();
        return new BBCSportPage(driver);
//        BBCSportPage sportPage = new BBCSportPage(driver);
//        return sportPage;
    }


}